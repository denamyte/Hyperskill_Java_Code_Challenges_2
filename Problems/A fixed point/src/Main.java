import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int fixedPointBinarySearch(int[] arr) {
        int from = 0;
        int to = arr.length - 1;
        while (from <= to && arr[from] <= from && arr[to] >= to) {
            int mid = (from + to) >>> 1;
            if (arr[mid] == mid) {
                return mid;
            }
            if (arr[mid] > mid) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = fixedPointBinarySearch(arr);
        System.out.println(index >= 0);
    }
}