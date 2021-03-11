import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void countingSort(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        int shift = -min;
        int countsLen = max + shift + 1;
        int[] counts = new int[countsLen];

        shiftNumbers(numbers, shift);
        for (int number : numbers) {
            counts[number]++;
        }

        int pos = 0;
        for (int i = 0; i < countsLen; i++) {
            int count = counts[i];
            while (count-- > 0) {
                numbers[pos++] = i;
            }
        }
        shiftNumbers(numbers, -shift);
    }

    public static void shiftNumbers(int[] numbers, int shift) {
        if (shift != 0) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] += shift;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String elements = scanner.nextLine();
        final int[] array = Arrays.stream(elements.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        countingSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}