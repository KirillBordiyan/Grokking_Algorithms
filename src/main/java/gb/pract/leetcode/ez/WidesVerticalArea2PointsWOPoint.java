package gb.pract.leetcode.ez;

import java.util.*;

public class WidesVerticalArea2PointsWOPoint {
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{new int[]{8, 7}, new int[]{9, 9}, new int[]{7, 4}, new int[]{9, 7}}));

    }

    public static int maxWidthOfVerticalArea(int[][] points){
        int[] coordX = new int[points.length];

        for(int i = 0; i< points.length; i++){
            coordX[i] = points[i][0];
        }

        Arrays.sort(coordX);

        int dist = 0;
        for(int i = 1; i< coordX.length; i++){
            dist = Math.max(dist, coordX[i] - coordX[i-1]);
        }
        return dist;
    }



    public static int maxWidthOfVerticalArea3(int[][] points){
        int dist = 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < points.length-1; i++){
            if(Math.abs(points[i][0] - points[i+1][0]) > dist){
                dist = Math.abs(points[i][0] - points[i+1][0]);
            }
        }

        return dist;
    }

    public static int maxWidthOfVerticalArea2(int[][] points) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            list.add(points[i][0]);
        }

        Collections.sort(list);
        int dist = 0;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i+1) - list.get(i) > dist){
                dist = list.get(i+1) - list.get(i);
            }
        }

        return dist;
    }
}
