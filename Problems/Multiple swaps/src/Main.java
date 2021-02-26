import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var list = new ArrayList<>(List.of(scanner.nextLine().split("\\s+")));
        int count = scanner.nextInt();
        while (count-- > 0) {
            Collections.swap(list, scanner.nextInt(), scanner.nextInt());
        }
        list.forEach(s -> System.out.printf("%s ", s));
    }
}
