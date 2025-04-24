package gb.pract.timus.antirude;

import java.util.*;


public class AntiRude {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countWords = Integer.parseInt(sc.nextLine());
        String[] badWords = new String[countWords];

        for (int i = 0; i < countWords; i++) {
            badWords[i] = sc.nextLine();
        }

        int m = Integer.parseInt(sc.nextLine());
        String[] text = new String[m];

        for (int i = 0; i < m; i++) {
            text[i] = sc.nextLine();
        }

        Map<String, int[]> map = new LinkedHashMap<>();
        for (String word : badWords) {
            map.put(word, null);
        }

        for (int i = 0; i < m; i++) {
            String line = text[i];
            for (String word : badWords) {
                if (map.get(word) != null) continue;
                int position = line.indexOf(word);
                if (position != -1) {
                    map.put(word, new int[]{i+1, position + 1});
                }
            }
        }
        boolean find = false;
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] position = entry.getValue();
            if (position != null) {
                if(find){
                    System.out.print("\n" + position[0] + " " + position[1]);
                } else {
                    System.out.print(position[0] + " " + position[1]);
                }
                find = true;
            }
        }

        if (!find) {
            System.out.print("Passed");
        }

    }
}


//    public static void main2(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int countWords = Integer.parseInt(sc.nextLine());
//        String[] words = new String[countWords];
//
//        for (int i = 0; i < countWords; i++) {
//            words[i] = sc.nextLine();
//        }
//
//        int countLines = Integer.parseInt(sc.nextLine());
//        String[][] lines = new String[countLines][];
//
//        for (int i = 0; i < countLines; i++) {
//            lines[i] = sc.nextLine().split(" ");
//        }
//
//        Map<String, int[]> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, null);
//        }
//
//        for (int li = 0; li < countLines; li++) {
//            String l =
//        }

//        int[][] result = new int[countWords][2];
//        int prevLen = 0;
//
//        for (int i = 0; i < countLines; i++) {
//            for (int j = 0; j < lines[i].length; j++) {
//                for (int w = 0; w < countWords; w++) {
//                    if (lines[i][j].contains(words[w])) {
//                        System.out.printf("%s %s\n",i, prevLen+j);
////                        result[w][0] = i;
////                        result[w][1] = prevLen + j;
//                        prevLen = 0;
//                        break;
//                    }
//                }
//            }
//            prevLen += lines[i].length;
//        }
//        if (result[0] != null) {
//            System.out.println(Arrays.deepToString(result));
//        } else {
//            System.out.print("Passed");
//        }
//    }
//}


