import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        final String[] strings = Stream.generate(scanner::nextLine)
                .limit(count)
                .toArray(String[]::new);

        System.out.println(strings[getRepresentativeIndex(strings)]);
    }

    private static int getRepresentativeIndex(String[] strings) {
        return IntStream.range(0, strings.length)
                .mapToObj(i -> new int[]{i, hammingDistanceRange(strings[i], strings)})
                .reduce((res1, res2) -> res2[1] < res1[1] ? res2 : res1).orElseThrow()[0];
    }

    static int hammingDistanceRange(String s, String[] strings) {
        return Arrays.stream(strings).mapToInt(nextStr -> hammingDistance(s, nextStr)).sum();
    }

    static int hammingDistance(String s1, String s2) {
        return (int) IntStream.range(0, s1.length())
                .mapToObj(i -> s1.charAt(i) != s2.charAt(i))
                .filter(b -> b).count();
    }
}