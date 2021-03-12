import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void changeHeadsAndTails(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        if (linkedList.isEmpty() || arrayList.isEmpty()) {
            return;
        }
        String[] linkedBorders = {linkedList.pollFirst(), linkedList.pollLast()};
        linkedList.addFirst(arrayList.get(0));
        linkedList.addLast(arrayList.get(arrayList.size() - 1));
        arrayList.set(0, linkedBorders[0]);
        arrayList.set(arrayList.size() - 1, linkedBorders[1]);
    }

//    public static void main(String[] args) {
//        LinkedList<String> linkedList = new LinkedList<>(List.of("f", "b", "c", "d", "j"));
//        ArrayList<String> arrayList = new ArrayList<>(List.of("a", "g", "h", "i", "e"));
//        changeHeadsAndTails(linkedList, arrayList);
//        System.out.println(linkedList);
//        System.out.println(arrayList);
//    }
}