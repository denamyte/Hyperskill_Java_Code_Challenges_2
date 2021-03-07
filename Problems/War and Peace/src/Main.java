import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .forEach((k, v) -> System.out.printf("%s %d%n", k, v));
    }
}