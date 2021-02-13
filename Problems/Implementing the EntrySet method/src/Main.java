import java.util.*;

public class Main {
    // Sorry, guys, who invent the tasks like this the same way as one
    //  would shoot a cannon at sparrows, but I could not find
    //  any reason to implement you strange structures
    //  to realize you strange ideas...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        for (int i = Integer.parseInt(scanner.nextLine()); i > 0; i--) {
            String[] ar = scanner.nextLine().split("\\W+");
            map.compute(Integer.parseInt(ar[0]), (k, v) -> v == null ? ar[1] : String.format("%s %s", v, ar[1]));
        }
        map.forEach((k, v) -> System.out.printf("%d: %s%n", k, v));
    }
}