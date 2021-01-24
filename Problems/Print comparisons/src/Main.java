import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        // Both approaches work but the latter is much faster
        countComparisons(n);
//        new JumpSearchCounter(n);
    }

    static void countComparisons(int n) {
        int jumpSize = (int) Math.sqrt(n);
        printf(1);
        IntStream.rangeClosed(2, n).map(value -> {
            int blockIndex = (value - 2) / jumpSize;
            if (blockIndex == (n - 1) / jumpSize) {
                return blockIndex + 2 + n - value;
            }
            return blockIndex + 1 + jumpSize - (value - 2) % jumpSize;
        }).forEach(Main::printf);
    }

    static void printf(int value) {
        System.out.printf("%d ", value);
    }
}

//class JumpSearchCounter {
//
//    private final int n;
//    private final AtomicInteger counter = new AtomicInteger();
//
//    JumpSearchCounter(int n) {
//        this.n = n;
//        int[] array = createArray(n);
//        IntStream.rangeClosed(1, n).map(value -> {
//            counter.set(0);
//            jumpSearch(array, value, counter);
//            return counter.get();
//        }).forEach(value -> System.out.printf("%d ", value));
//    }
//
//    public static int[] createArray(int n) {
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = i + 1;
//        }
//        return array;
//    }
//
//    public static int jumpSearch(int[] array, int target, AtomicInteger counter) {
//        int blockRight = 0;
//        int prevBlockRight = 0;
//
//        if (array.length == 0) {  // this doesn't work in this task
//            return -1;
//        }
//
//        if (array[blockRight] == target) {
//            counter.incrementAndGet();
//            return 0;
//        }
//
//        int jumpSize = (int) Math.sqrt(array.length);
//        int lastIndex = array.length - 1;
//
//        while (blockRight < lastIndex) {
//
//            blockRight = Math.min(blockRight + jumpSize, lastIndex);
//
//            counter.incrementAndGet();
//            if (array[blockRight] >= target) {
//                break;
//            }
//
//            prevBlockRight = blockRight;
//        }
//
//        if (blockRight == lastIndex && array[lastIndex] < target) {
//            return -1;
//        }
//
//        return backwardSearch(array, target, prevBlockRight, blockRight, counter);
//    }
//
//    public static int backwardSearch(int[] array, int target, int left, int right, AtomicInteger counter) {
//        for (int i = right; i > left; i--) {
//
//            counter.incrementAndGet();
//            if (array[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }
//}

