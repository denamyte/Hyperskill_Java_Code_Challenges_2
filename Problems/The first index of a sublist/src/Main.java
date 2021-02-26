import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var list1 = getList(scanner);
        var list2 = getList(scanner);
        System.out.printf("%d %d%n",
                          Collections.indexOfSubList(list1, list2),
                          Collections.lastIndexOfSubList(list1, list2));
    }

    static List<String> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
    }
}