import java.math.BigInteger;
import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(bi().abs().multiply(bi()).add(bi()).subtract(bi()));
    }

    static BigInteger bi() {
        return new BigInteger(sc.next());
    }
}