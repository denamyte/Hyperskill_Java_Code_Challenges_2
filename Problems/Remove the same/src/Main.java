import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static <T> void removeTheSame(LinkedList<T> li, ArrayList<T> ar) {
        for (int i = 0; i < ar.size(); i++) {
            if (li.get(i).equals(ar.get(i))) {
                li.remove(i);
                ar.remove(i);
                i--;
            }
        }
    }
}