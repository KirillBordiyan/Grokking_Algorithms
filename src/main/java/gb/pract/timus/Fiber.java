package gb.pract.timus;

import java.util.Locale;
import java.util.Scanner;

public class Fiber {
    //comments

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        double R = Double.parseDouble(firstLine[1]);

        double[][] points = new double[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(" ");
            points[i][0] = Double.parseDouble(line[0]);
            points[i][1] = Double.parseDouble(line[1]);
        }
        scanner.close();

        double perimeter = 0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            perimeter += findDistance(points[i], points[next]);
        }

        perimeter += 2 * Math.PI * R;

        System.out.printf(Locale.US,"%.2f", perimeter);
    }

    private static double findDistance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}
