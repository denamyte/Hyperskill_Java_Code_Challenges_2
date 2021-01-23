import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] haystack = getIntArray(scanner);
        int[] needles = getIntArray(scanner);
        for (int needle : needles) {
            // Let's omit the implementation of binary search here, it's the same as the standard one
            int ind = Arrays.binarySearch(haystack, needle);
            System.out.printf("%d ", ind > -1 ? ind + 1 : -1);
        }
    }

    static int[] getIntArray(Scanner scanner) {
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        return ar;
    }
}