import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int length = scanner.nextInt();

        int[] results = IntStream.range(0, lines)
                .mapToObj(i -> IntStream.generate(scanner::nextInt).limit(length).toArray())
                .mapToInt(Main::selectionSortCounter)
                .toArray();

        int max = results[0];
        int maxIndex = 0;
        for (int i = 0; i < lines; i++) {
            if (max < results[i]) {
                max = results[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + 1);

    }

    public static int selectionSortCounter(int[] array) {
        int exchanges = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    exchanges++;
                    index = j;
                }
            }

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        exchanges += array.length - 1;
        return exchanges;
    }
}