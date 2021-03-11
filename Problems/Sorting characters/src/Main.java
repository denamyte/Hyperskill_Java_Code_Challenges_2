import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void countingSort(int[] numbers) {
        int countsLen = 10;
        int[] counts = new int[countsLen];

        for (int number : numbers) {
            counts[number]++;
        }

        int pos = 0;
        for (char i = 0; i < countsLen; i++) {
            int count = counts[i];
            while (count-- > 0) {
                numbers[pos++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int shift = 'a';
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> value.charAt(0) - shift).toArray();

        countingSort(numbers);

        String res = Arrays.stream(numbers).collect(
                StringBuilder::new,
                (sb, val) -> sb.append((char) (val + shift)).append(" "),
                (sb1, sb2) -> {}).toString();
        System.out.println(res);
    }

}