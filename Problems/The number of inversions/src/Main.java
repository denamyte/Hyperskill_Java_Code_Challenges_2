import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        AtomicLong inversionCounter = new AtomicLong();
        mergeSort(array, 0, array.length, inversionCounter);

        System.out.println(inversionCounter.get());
    }

    public static void mergeSort(int[] array, int leftIncl, int rightExcl, AtomicLong invCnt) {
        if (rightExcl <= leftIncl + 1) {
            return;
        }
        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle, invCnt);
        mergeSort(array, middle, rightExcl, invCnt);

        merge(array, leftIncl, middle, rightExcl, invCnt);
    }

    private static void merge(int[] array, int left, int middle, int right, AtomicLong invCnt) {
        int i = left;
        int j = middle;
        int k = 0;

        int[] temp = new int[right - left];

        while (i < middle && j < right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                invCnt.addAndGet(middle - i);
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        if (i < middle) {
            System.arraycopy(array, i, temp, k, middle - i);
        } else if (j < right) {
            System.arraycopy(array, j, temp, k, right - j);
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}