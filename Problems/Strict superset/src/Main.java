import java.util.Scanner;
import java.util.Set;

public class Main {

    private static <T> boolean isStrictSuperset(final Set<T> set1, final Set<T> set2) {
        return !set1.equals(set2) && set2.containsAll(set1);
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Set.of(scanner.nextLine().split("\\s+"));
    }
}