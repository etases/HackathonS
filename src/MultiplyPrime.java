import java.util.Scanner;

public class MultiplyPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int min = Math.min(x, y);
        int max = Math.max(x, y);

        long result = 1;
        for (int i = min; i <= max; i++) {
            if (i > 0 && isPrime(i)) {
                result *= i;
            }
        }

        System.out.println(result);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}