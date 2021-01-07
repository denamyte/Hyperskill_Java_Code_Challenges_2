import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        float p1 = -b / (2 * a);
        float p2 = (float) (Math.sqrt(b * b - 4 * a * c) / (2 * a));
        float[] parts = {p1 + p2, p1 - p2};
        Arrays.sort(parts);
        System.out.printf("%f %f%n", parts[0], parts[1]);
    }
}