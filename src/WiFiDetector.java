import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiFiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] input = userInput.split(" ");
        double userX = Double.parseDouble(input[0]);
        double userY = Double.parseDouble(input[1]);

        int numOfWifi = Integer.parseInt(scanner.nextLine());
        List<WiFi> wifiList = new ArrayList<>();
        for (int i = 0; i < numOfWifi; i++) {
            String name = scanner.nextLine();
            String[] wifiInput = scanner.nextLine().split(" ");
            double x = Double.parseDouble(wifiInput[0]);
            double y = Double.parseDouble(wifiInput[1]);
            double r = Double.parseDouble(wifiInput[2]);
            wifiList.add(new WiFi(name, x, y, r));
        }

        List<WiFi> result = new ArrayList<>();
        for (WiFi wifi : wifiList) {
            if (wifi.isInRange(userX, userY)) {
                result.add(wifi);
            }
        }

        System.out.println(result.size());
        for (WiFi wifi : result) {
            System.out.println(wifi.getName());
        }
    }

    public static class WiFi {
        private String name;
        private double x;
        private double y;
        private double r;

        public WiFi(String name, double x, double y, double r) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public String getName() {
            return name;
        }

        public boolean isInRange(double x, double y) {
            return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= r;
        }
    }
}
