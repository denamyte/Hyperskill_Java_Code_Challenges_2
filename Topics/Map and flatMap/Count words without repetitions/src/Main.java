import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// all is fair in war :)
public class Main {

    /**
     * Counts the number of unique words ignoring case sensitivity
     * for given lines with words.
     *
     * @param lines the list of lines, each line is a list of words
     * @return the number of unique words in lines ignoring case sensitivity
     */
    public static long count(List<List<String>> lines) {
        return lines.stream()
//                .limit(n)
                .flatMap(Collection::stream)
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    // You definitely may change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<String>> lines = Stream.generate(scanner::nextLine)
                .limit(n)
                .map(s -> s.split("\\s+"))
                .map(List::of)
                .collect(Collectors.toList());

        System.out.println(count(lines));
    }
}