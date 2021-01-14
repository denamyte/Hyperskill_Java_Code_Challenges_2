import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = IntStream.generate(scanner::nextInt).limit(3).toArray();
        Random rnd = new Random(data[1] + data[2]);
        System.out.println(IntStream.generate(() -> rnd.nextInt(data[2] - data[1] + 1) + data[1]).limit(data[0]).sum());
    }
}