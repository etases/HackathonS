import java.text.DecimalFormat;
import java.util.Scanner;

public class LargestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            points[i][0] = Integer.parseInt(input[0]);
            points[i][1] = Integer.parseInt(input[1]);
        }

        int max = 0;
        int p1 = 0;
        int p2 = 1;
        int p3 = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = points[i][0] - points[j][0];
                    int b = points[i][1] - points[j][1];
                    int c = points[i][0] - points[k][0];
                    int d = points[i][1] - points[k][1];
                    int area = Math.abs(a * d - b * c);
                    if (area > max) {
                        max = area;
                        p1 = i;
                        p2 = j;
                        p3 = k;
                    }
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#.0");
        String result = df.format(max / 2.0);
        System.out.printf("(%d %d) (%d %d) (%d %d) area=%s", points[p1][0], points[p1][1], points[p2][0], points[p2][1], points[p3][0], points[p3][1], result);
    }
}
