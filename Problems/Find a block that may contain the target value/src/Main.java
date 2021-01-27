import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int[] bounds = jumpSearchForPossibleBlock(array, target);
        for (int bound : bounds) {
            System.out.printf("%d ", bound);
        }
    }
    public static int[] jumpSearchForPossibleBlock(int[] array, int target) {
        int blockLeft;
        int blockRight = -1;

        int lastIndex = array.length - 1;
        if (array.length == 0 || array[0] > target || array[lastIndex] < target) {
            return new int[]{-1};
        }

        int jumpSize = (int) Math.sqrt(array.length);

        while (blockRight < lastIndex) {
            blockLeft = blockRight + 1;
            blockRight = Math.min(blockRight + jumpSize, lastIndex);

            if (array[blockRight] >= target) {
                return new int[]{blockLeft, blockRight};
            }
        }
        return new int[]{-1};
    }
}
