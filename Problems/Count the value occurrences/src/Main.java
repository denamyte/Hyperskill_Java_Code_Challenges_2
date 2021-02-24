import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        return countOccurrences(elem, list1) == countOccurrences(elem, list2);
    }

    static <T> int countOccurrences(T elem, List<T> list) {
        return (int) list.stream().filter(elem::equals).count();
    }

//    public static void main(String[] args) {
//        System.out.println(checkTheSameNumberOfTimes(3, List.of(8, 8, 3, 3, 2), List.of(1, 3, 3, 2)));
//        System.out.println(checkTheSameNumberOfTimes(3, List.of(9, 8, 4, 3, 2), List.of(1, 3, 3, 3)));
//    }
}