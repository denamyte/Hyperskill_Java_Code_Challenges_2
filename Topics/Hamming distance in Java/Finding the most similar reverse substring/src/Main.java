import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] res = new HammingVariations(scanner.nextLine(), scanner.nextLine(), scanner.nextInt()).calculate();
        System.out.printf("%d %d", res[0], res[1]);
    }
}

class HammingVariations {

    private final String s1;
    private final String s2;
    private final int substringLength;

    public HammingVariations(String s1, String s2, int substringLength) {
        this.s1 = s1;
        this.s2 = s2;
        this.substringLength = substringLength;
    }

    public int[] calculate() {
        return IntStream.range(0, s1.length() - substringLength + 1)
                .mapToObj(i -> new int[]{i, hammingDistanceOfSubstr(i)})
                .reduce((res1, res2) -> res2[1] < res1[1] ? res2 : res1).orElseThrow();
    }

    /** Take a substring <b>s1[from:from+substringLength]</b>, reverse it and compare
     *  with a substring <b>s2[from:from+substringLength]</b> */
    private int hammingDistanceOfSubstr(int from) {
        final String sRev = new StringBuilder(s1.substring(from, from + substringLength)).reverse().toString();
        return (int) IntStream.range(0, substringLength)
                .mapToObj(i -> sRev.charAt(i) != s2.charAt(i + from))
                .filter(b -> b).count();
    }

}