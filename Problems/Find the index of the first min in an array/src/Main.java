import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findIndexOfMin(int[] numbers) {
        int[] min = {-1, Integer.MAX_VALUE};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min[1]) {
                min = new int[]{i, numbers[i]};
            }
        }
        return min[0];
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        } else {
            numbers = new int[0];    
        }
        System.out.println(findIndexOfMin(numbers));
    }
}