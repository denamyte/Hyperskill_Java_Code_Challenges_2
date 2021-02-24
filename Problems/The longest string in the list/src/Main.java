import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        final String longest = list.stream().reduce("", (s, s2) -> s.length() > s2.length() ? s : s2);
        Collections.fill(list, longest);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}