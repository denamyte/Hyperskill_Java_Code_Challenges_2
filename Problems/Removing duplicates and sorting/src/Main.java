import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Stream.generate(scanner::nextLine).limit(Integer.parseInt(scanner.nextLine()))
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println);
    }
}