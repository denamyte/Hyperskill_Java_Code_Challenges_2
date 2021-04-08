import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    // All these currying expansions are just for fun :)
    public static final Function<String, Predicate<String>> NOT_EQUALS_FN = s -> Predicate.not(s::equals);

    public static final Predicate<String> NOT_0000 = NOT_EQUALS_FN.apply("#0000");
    public static final Predicate<String> NOT_FFFF = NOT_EQUALS_FN.apply("#FFFF");

    private static List<String> extractCodes(List<String> codes) {
        return codes.stream()
                .dropWhile(NOT_0000)
                .skip(1)
                .takeWhile(NOT_FFFF).collect(Collectors.toList());
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}