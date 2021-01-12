import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int value = new Scanner(System.in).nextInt();
        decompose(value, value, null);
    }

    static void decompose(int number, int max, String prefix) {
        if (number == 0) {
            System.out.println(prefix);
        }
        for (int i = 1; i <= max; i++) {
            decompose(number - i, Math.min(number - i, i),
                      prefix == null ? "" + i : prefix + ' ' + i);
        }
    }
}