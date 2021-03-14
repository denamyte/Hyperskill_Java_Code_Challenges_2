import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class Main {

    static Map<Integer, BiPredicate<Integer, Integer>> predicates = Map.of(
            0, (i, max) -> i > max,
            1, (i, min) -> i < min
    );

    public static void main(String[] args) {
        int[] array = new Scanner(System.in).tokens().skip(1).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(selectionSort(array)).forEach(i -> System.out.printf("%d ", i));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            var predicate = predicates.get(i % 2);
            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (predicate.test(array[j], array[index])) {
                    index = j;
                }
            }

            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }

        return array;
    }
}