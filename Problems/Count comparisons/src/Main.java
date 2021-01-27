import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = IntStream.generate(scanner::nextInt).limit(scanner.nextInt()).toArray();
        int target = scanner.nextInt();
        System.out.println(new JumpSearchCounter(array, target).getCount());
    }
}

class JumpSearchCounter {

    private final AtomicInteger counter = new AtomicInteger();

    JumpSearchCounter(int[] array, int target) {
        jumpSearch(array, target, counter);
    }

    public static int jumpSearch(int[] array, int target, AtomicInteger counter) {
        int blockRight = 0;
        int prevBlockRight = 0;

        counter.incrementAndGet();
        int lastIndex = array.length - 1;
        if (array.length == 0) {
            return -1;
        }

        if (array[0] == target) {
            return 0;
        }

        int jumpSize = (int) Math.sqrt(array.length);

        while (blockRight < lastIndex) {

            blockRight = Math.min(blockRight + jumpSize, lastIndex);

            if (array[blockRight] >= target) {
                break;
            }
            counter.incrementAndGet();

            prevBlockRight = blockRight;
        }

        if (blockRight == lastIndex && array[lastIndex] < target) {
            return -1;
        }

        return backwardSearch(array, target, prevBlockRight, blockRight, counter);
    }

    public static int backwardSearch(int[] array, int target, int left, int right, AtomicInteger counter) {
        for (int i = right; i > left; i--) {

            counter.incrementAndGet();
            if (array[i] < target) {
                break;
            }
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int getCount() {
        return counter.get();
    }
}