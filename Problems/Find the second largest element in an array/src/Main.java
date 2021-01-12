import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int findSecondLargestNumber(int[] numbers) {
        List<Integer> nums = Arrays.stream(numbers).distinct().boxed().collect(Collectors.toList());
        if (nums.size() <= 1) {
            return Integer.MIN_VALUE;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int value : nums) {
            if (value > first) {
                second = first;
                first = value;
            } else if (value > second) {
                second = value;
            }
        }
        return second;
    }

    public static int findSecondLargestNumber2(int[] numbers) {
        ArrayList<Integer> nums = Arrays.stream(numbers).distinct().boxed().collect(Collectors.toCollection(ArrayList::new));
        if (nums.size() <= 1) {
            return Integer.MIN_VALUE;
        }
        Collections.sort(nums);
        return nums.get(nums.size() - 2);
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
        System.out.println(findSecondLargestNumber2(numbers));
    }
}