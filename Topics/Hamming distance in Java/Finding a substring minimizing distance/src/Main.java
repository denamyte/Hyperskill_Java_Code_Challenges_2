import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] res = hammingSubstrings(scanner.nextLine(), scanner.nextLine());
        System.out.printf("%s %s", res[0], res[1]);
    }

    /** Returns an integer array, containing the index of the best match in index 0
     *  and the hamming distance in index 1. */
    static int[] hammingSubstrings(String p, String s) {
        return IntStream.range(0, s.length() - p.length() + 1)
                .mapToObj(i -> new int[]{i, hammingDistanceOfSubstr(p, s, i)})
                .reduce(new int[]{-1, p.length() + 1}, (res1, res2) -> res2[1] < res1[1] ? res2 : res1);
    }

    static int hammingDistanceOfSubstr(String p, String s, int from) {
        return (int) IntStream.range(0, p.length())
                .mapToObj(i -> p.charAt(i) != s.charAt(i + from))
                .filter(b -> b).count();
    }
}
