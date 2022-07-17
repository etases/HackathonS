import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        double result = 1;

        for (int i = 1; i <= n; i++) {
            double temp = (Math.pow(-1, i - 1) * Math.pow(x, i));
            for (int j = 1; j <= i; j++) {
                temp /= j;
            }
            result += temp;
        }

        // print the number with 6 decimal places
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format(result));
    }
}
