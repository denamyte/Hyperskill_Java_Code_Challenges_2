import java.util.Scanner;
import java.util.function.Function;

class CurryConcat {

    public static String calc(String... ss) {

        Function<String, Function<String, Function<String, Function<String, String>>>> stringFun =
                s1 -> s2 -> s3 -> s4 -> s1.toLowerCase() + s3.toUpperCase() + s2.toLowerCase() + s4.toUpperCase();

        return stringFun.apply(ss[0]).apply(ss[1]).apply(ss[2]).apply(ss[3]);
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");
        System.out.println(calc(values[0], values[1], values[2], values[3]));
    }
}