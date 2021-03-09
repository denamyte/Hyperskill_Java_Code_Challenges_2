import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] ar = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        bubbleSort(ar);
        System.out.println(counter.get());
    }

    static void bubbleSort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] < ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    counter.incrementAndGet();
                }
            }
        }
    }
}