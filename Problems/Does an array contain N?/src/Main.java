import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] nums = IntStream.generate(scanner::nextInt).limit(scanner.nextInt()).toArray();
            int i = scanner.nextInt();
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            System.out.println(found);
        }
    }
}