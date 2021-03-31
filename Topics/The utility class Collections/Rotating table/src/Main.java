import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();
        scanner.nextLine();
        String[] ar = Stream.generate(scanner::nextLine).limit(lineCount).toArray(String[]::new);
        int shift = -Integer.parseInt(scanner.nextLine());
        while (shift < 0) {
            shift += lineCount;
        }
        for (int i = 0; i < lineCount; i++) {
            System.out.println(ar[(i + shift) % lineCount]);
        }
    }
}