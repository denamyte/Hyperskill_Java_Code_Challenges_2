import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> list = new ArrayList<>(List.of(array));
        final ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            final String next = it.next();
            if (next.charAt(0) == 'J') {
                it.set(next.substring(1));
            } else {
                it.remove();
            }
        }
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}