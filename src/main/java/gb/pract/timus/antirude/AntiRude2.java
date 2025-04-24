package gb.pract.timus.antirude;

import java.util.*;

public class AntiRude2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] badWords = new String[n];
        for (int i = 0; i < n; i++) {
            badWords[i] = sc.nextLine().toLowerCase();
        }

        int m = Integer.parseInt(sc.nextLine());
        Map<String, int[]> found = new LinkedHashMap<>(n);

        for (int j = 0; j < m; j++) {
            String lowerCase = sc.nextLine().toLowerCase();
            for (String bad : badWords) {
                if (!found.containsKey(bad) && lowerCase.contains(bad)) {
                    found.put(bad, new int[]{j+1, lowerCase.indexOf(bad) + 1});
                }
            }
        }


        boolean any = false;
        for (String bad : badWords) {
            if (found.containsKey(bad)) {
                int[] pos = found.get(bad);
                if(any){
                    System.out.println("\n"+pos[0] + " " + pos[1]);
                } else {
                    System.out.print(pos[0] + " " + pos[1]);
                }
                any = true;
            }
        }

        if (!any) {
            System.out.print("Passed");
        }
    }
}

/*
5
dear
sweetie
angel
dream
baby
8
Had I the heavens' embroidered cloths,
Enwrought with golden and silver light,
The blue and the dim and the dark cloths
Of night and light and the half-light,
I would spread the cloths under your feet:
But I, being poor, have only my Dreams;
I have spread my dreams under your feet;
Tread softly because you tread on my dreams.




2
dream
code
3
I had dreams yesterday
We love to code
Nothing bad here
 */
