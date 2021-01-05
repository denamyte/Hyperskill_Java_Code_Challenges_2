import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double[] sides = new Scanner(System.in).tokens().limit(3).mapToDouble(Double::parseDouble).toArray();
        double p = Arrays.stream(sides).sum() / 2;
        System.out.println(Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2])));
    }
}