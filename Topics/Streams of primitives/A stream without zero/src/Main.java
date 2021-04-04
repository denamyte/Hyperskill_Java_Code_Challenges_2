import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class StreamOfPrimitives {

    public static LongStream getLongStream(int n) {
        return Stream.of(LongStream.range(-n, 0), LongStream.rangeClosed(1, n))
                .flatMapToLong(Function.identity());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String result = getLongStream(n).mapToObj(e -> e)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}