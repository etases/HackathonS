import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CeaserCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plain = sc.nextLine();
        String corrupted = sc.nextLine();
        int size = plain.length();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int pc = plain.charAt(i);
            if (!Character.isAlphabetic(pc)) continue;
            int cc = corrupted.charAt(i);
            int diff = cc - pc;
            map.merge(diff, 1, Integer::sum);
        }

        int max = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = alphabet.toUpperCase();

        System.out.println(key);
        char[] cipher = new char[size];
        boolean shouldPrint = false;
        for (int i = 0; i < size; i++) {
            char pc = plain.charAt(i);
            char cc = corrupted.charAt(i);
            char coc;
            if (Character.isAlphabetic(pc)) {
                if (Character.isUpperCase(pc)) {
                    int index = upperAlphabet.indexOf(pc);
                    coc = upperAlphabet.charAt(((index + key) + 26) % 26);
                } else {
                    int index = alphabet.indexOf(pc);
                    coc = alphabet.charAt(((index + key) + 26) % 26);
                }
            } else {
                coc = pc;
            }
            if (coc != cc) {
                shouldPrint = true;
            }
            cipher[i] = coc;
        }

        if (shouldPrint) {
            System.out.println(new String(cipher));
        } else {
            System.out.println("No error");
        }
    }
}
