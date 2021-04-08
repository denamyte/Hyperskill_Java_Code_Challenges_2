import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ProcessNumbers {

    public static final Predicate<Integer> TOO_SMALL = i -> i < 10;

    public static List<Integer> processNumbers(Collection<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .dropWhile(TOO_SMALL)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        String result = processNumbers(numbers).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}