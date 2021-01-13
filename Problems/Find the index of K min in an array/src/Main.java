import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int findIndexOfKMin(int[] numbers, int k) {
        ArrayList<Integer> indices = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min) {
                indices.add(i);
            } else if (numbers[i] < min) {
                min = numbers[i];
                indices.clear();
                indices.add(i);
            }
        }
        return k - 1 >= indices.size() ? -1 : indices.get(k - 1);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int k;
        final int[] numbers;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            k = Integer.parseInt(scanner.nextLine());
        } else {
            numbers = new int[0];
            k = 1;
        }
        System.out.println(findIndexOfKMin(numbers, k));
    }
}