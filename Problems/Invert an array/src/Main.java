// do not remove imports

import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    ArrayList dumbList;
    List dumbList2;
    Scanner dumbScanner;
    Function dumbFunction;

    static <T> T[] invert(T[] array) {
        int lastInd = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[lastInd - i];
            array[lastInd - i] = temp;
        }
        return array;
    }
}