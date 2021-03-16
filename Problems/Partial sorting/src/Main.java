import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] ar = new int[length];
        for (int i = 0; i < length; i++) {
            ar[i] = Integer.parseInt(scanner.next());
        }

        int k = scanner.nextInt();
        partialSelectionSort(ar, k);
        for (int i = 0; i < k; i++) {
            System.out.printf("%d ", ar[i]);
        }
    }

    public static void partialSelectionSort(int[] array, int count) {
        for (int i = 0; i < count; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}