package gb.pract.groAlg;

import java.util.*;

public class BreaadthFirstSearch {
    public static void main(String[] args) {
        Map<String, List<String>> searching = new HashMap();
        searching.put("you", List.of("alice", "bob", "claire"));
        searching.put("alice", List.of("peggy"));
        searching.put("bob", List.of("peggy", "anuj"));
        searching.put("claire", List.of("thom", "jonny"));

        searching.put("peggy", Collections.emptyList());
        searching.put("anuj", Collections.emptyList());
        searching.put("jonny", Collections.emptyList());
        searching.put("thom", Collections.emptyList());


        searchMangoSeller(searching, "you");


    }

    public static boolean searchMangoSeller(Map<String, List<String>> map, String name) {
        Queue<String> queue = new ArrayDeque<>(map.get(name));
        ArrayList<String> searched = new ArrayList<>();

        int maxLenghtToFindSellerIfExist = 0;

        while (!queue.isEmpty()) {
            String person = queue.poll();
            maxLenghtToFindSellerIfExist++;
            if (!searched.contains(person)) {
                System.out.println(person);
                System.out.println(searched);
                if (isPersonSeller(person)) {
                    System.out.print(person + " is seller. Got it!");

                    System.out.println(maxLenghtToFindSellerIfExist);
                    return true;
                } else {
                    queue.addAll(map.get(person));
                    searched.add(person);
                    maxLenghtToFindSellerIfExist--;
                }
            }
        }
        return false;
    }

    public static boolean isPersonSeller(String person) {
        return person.charAt(person.length() - 1) == 'm';
    }


    public static void queueExamples() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue); //лежат друг за другом
        System.out.println(queue.poll()); //удаляет первый добавленный -> 1
        System.out.println(queue.poll()); //удаляет первый добавленный из оставшихся -> 2


        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        System.out.println(stack); //лежат друг на друге
        System.out.println(stack.pop()); //удаляет последний положенный -> 5
        System.out.println(stack.pop()); //удаляет последний положенный из оставшихся -> 4
        System.out.println(stack.remove(1));
        System.out.println(stack);
    }
}
