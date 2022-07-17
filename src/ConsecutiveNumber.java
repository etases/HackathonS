import java.util.Arrays;
import java.util.Scanner;

public class ConsecutiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        if (arr.length == 1) {
            System.out.println(1);
            return;
        }

        int curr = arr[0];
        int result = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            int next = arr[i];
            if (next != curr) {
                if (next == curr + 1) {
                    count++;
                } else {
                    if (count > result) {
                        result = count;
                    }
                    count = 1;
                }
            }
            curr = next;
        }
        System.out.println(Math.max(result, count));
    }
}
