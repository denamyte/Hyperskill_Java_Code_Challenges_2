import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        BigInteger m = new BigInteger(new Scanner(System.in).next());
        BigInteger fact = BigInteger.ONE;
        int i = 1;
        while (m.compareTo(fact) > 0) {
            fact = fact.multiply(BigInteger.valueOf(++i));
        }
        System.out.println(i);
    }
}