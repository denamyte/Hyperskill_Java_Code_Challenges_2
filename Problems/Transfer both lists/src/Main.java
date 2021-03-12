import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static <T> void transferAllElements(LinkedList<T> li, ArrayList<T> ar) {
        for (int i = 0; i < li.size(); i++) {
            li.add(ar.set(i, li.pollFirst()));
        }
    }

//    public static void main(String[] args) {
//        LinkedList<Integer> li = new LinkedList<>(List.of(0, 1, 2, 3, 4));
//        ArrayList<Integer> ar = new ArrayList<>(List.of(5, 6, 7, 8, 9));
//        transferAllElements(li, ar);
//        System.out.println(li);
//        System.out.println(ar);
//    }
}