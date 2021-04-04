import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

class Finder {

    private FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * It performs the search algorithm according to the given strategy
     */
    public int find(int[] numbers) {
        return strategy.getResult(numbers);
    }
}

interface FindingStrategy {

    /**
     * Returns search result
     */
    int getResult(int[] numbers);

}

class MaxFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {
        return Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
    }
}

class MinFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {

        // A map, as opposed to a switch, can really isolate the strategy code from client code.
        final Map<String, Supplier<Finder>> strategies = Map.of(
                "MIN", () -> new Finder(new MinFindingStrategy()),
                "MAX", () -> new Finder(new MaxFindingStrategy())
        );
        final Supplier<Finder> defSupp = () -> null;

        final Scanner scanner = new Scanner(System.in);

        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers;

        if (elements[0].equals("EMPTY")) {
            numbers = new int[0];   
        } else {
            numbers = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
        }

        Finder finder = strategies.getOrDefault(scanner.nextLine(), defSupp).get();

        // switch sucks :)
//        switch (type) {
//            case "MIN":
//                finder = new Finder(new MinFindingStrategy());
//                break;
//            case "MAX":
//                finder = new Finder(new MaxFindingStrategy());
//                break;
//            default:
//                break;
//        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}