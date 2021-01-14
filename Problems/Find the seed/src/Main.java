import java.util.Random;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seedFrom = scanner.nextInt();
        int seedTo = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        BinaryOperator<int[]> reducer = (ar1, ar2) -> ar1[1] <= ar2[1] ? ar1 : ar2;
        int[] min = IntStream.rangeClosed(seedFrom, seedTo).mapToObj(seed -> {

            Random rnd = new Random(seed);
            int max = IntStream.generate(() -> rnd.nextInt(k)).limit(n).max().orElseThrow();
            return new int[]{seed, max};

        }).reduce(reducer).orElseThrow();

        System.out.printf("%d%n%d", min[0], min[1]);
    }
}