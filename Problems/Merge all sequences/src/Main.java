import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int seqNumber = scanner.nextInt();
        while (seqNumber-- > 0) {
            int seqSize = scanner.nextInt();
            while (seqSize-- > 0) {
                list.add(scanner.nextInt());
            }
        }
        list.sort(Collections.reverseOrder());
        list.forEach(el -> System.out.printf("%d ", el));
    }
}