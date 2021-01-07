import java.util.Arrays;

class Problem {
    public static void main(String[] args) {
        int i = Arrays.binarySearch(args, "test");
        System.out.println(i < 0 ? -1 : i);
    }
}