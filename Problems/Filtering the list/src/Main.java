import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        final String[] ar = new Scanner(System.in).nextLine().split("\\s+");
        IntStream.iterate(ar.length - 1 - (ar.length & 1), i -> i > 0, i -> i - 2)
                .forEach(i -> System.out.printf("%s ", ar[i]));
    }
}