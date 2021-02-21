import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(calcInsertionSortShifts(ar));
    }

    public static int calcInsertionSortShifts(int[] array) {
        int shiftCount = 0;
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[minIndex]) {
                shiftCount++;
                continue;
            }
            minIndex = i;
        }
        return shiftCount;
    }
}