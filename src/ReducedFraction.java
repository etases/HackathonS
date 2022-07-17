import java.util.Scanner;

public class ReducedFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int gcd = gcd(Math.abs(x), Math.abs(y));
        int resultX = x / gcd;
        int resultY = y / gcd;
        if (resultY < 0) {
            resultX = -resultX;
            resultY = -resultY;
        }
        if (resultY == 1) {
            System.out.println(resultX);
        } else {
            System.out.println(resultX + " " + resultY);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
