package gb.pract.timus.antirude;

import java.util.*;

public class AntiRudeAhoCor {
    static class Node {
        Map<Character, Node> children = new HashMap<>();
        Node fail;
        List<String> outputs = new ArrayList<>();
    }

    static class AhoCorasick {
        Node root = new Node();

        public void addWord(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, c -> new Node());
            }
            node.outputs.add(word);
        }

        public void build() {
            Queue<Node> queue = new LinkedList<>();
            for (Node child : root.children.values()) {
                child.fail = root;
                queue.add(child);
            }

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
                    char ch = entry.getKey();
                    Node child = entry.getValue();
                    Node f = current.fail;
                    while (f != null && !f.children.containsKey(ch)) {
                        f = f.fail;
                    }
                    child.fail = (f != null) ? f.children.get(ch) : root;
                    child.outputs.addAll(child.fail.outputs);
                    queue.add(child);
                }
            }
        }

        // Search for bad words and return positions
        public Map<String, int[]> search(String[] lines) {
            Map<String, int[]> result = new HashMap<>();
            int globalWordPosition = 1;  // The global word position counter for the whole text

            for (int lineIndex = 0; lineIndex < lines.length; lineIndex++) {
                String line = lines[lineIndex];
                Node node = root;

                // Split line into words
                String[] wordsInLine = line.split("\\s+");
                List<Integer> wordStartIndexes = new ArrayList<>();
                int wordPositionInLine = 0;

                // Track the starting positions of each word in the line
                for (String word : wordsInLine) {
                    wordStartIndexes.add(wordPositionInLine);
                    wordPositionInLine += word.length() + 1;  // Add 1 for the space between words
                }

                // Traverse the current line for matching words
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    while (node != root && !node.children.containsKey(ch)) {
                        node = node.fail;
                    }
                    if (node.children.containsKey(ch)) {
                        node = node.children.get(ch);
                    }

                    // Check if any of the words match
                    for (String foundWord : node.outputs) {
                        if (!result.containsKey(foundWord)) {
                            // Find the word's start position in the line
                            int wordStartPos = i - foundWord.length() + 1;
                            int wordIndexInLine = findWordIndex(wordStartIndexes, wordStartPos);

                            // Calculate the global word position (starting from 1)
                            result.put(foundWord, new int[]{
                                    lineIndex + 1, // Line number
                                    globalWordPosition + wordIndexInLine // Global position of the word in text
                            });
                        }
                    }
                }

                // Update global word position by adding the number of words in the current line
                globalWordPosition += wordsInLine.length;
            }

            return result;
        }

        private int findWordIndex(List<Integer> wordStarts, int pos) {
            for (int i = 0; i < wordStarts.size(); i++) {
                if (wordStarts.get(i) > pos) {
                    return i - 1;
                }
            }
            return wordStarts.size() - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] badWords = new String[n];
        AhoCorasick ac = new AhoCorasick();

        // Read the "bad" words and add them to the Aho-Corasick automaton
        for (int i = 0; i < n; i++) {
            badWords[i] = sc.nextLine();
            ac.addWord(badWords[i]);
        }

        // Build the Aho-Corasick automaton
        ac.build();

        int m = Integer.parseInt(sc.nextLine());
        String[] lines = new String[m];

        // Read the text lines
        for (int i = 0; i < m; i++) {
            lines[i] = sc.nextLine();
        }

        // Search for the bad words in the text
        Map<String, int[]> found = ac.search(lines);
        boolean any = false;
        for (String word : badWords) {
            if (found.containsKey(word)) {
                int[] pos = found.get(word);
                System.out.println(pos[0] + " " + pos[1]);
                any = true;
            }
        }

        if (!any) {
            System.out.println("Passed");
        }
    }
}
