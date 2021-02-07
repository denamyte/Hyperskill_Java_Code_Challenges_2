// do not remove imports

import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    ArrayList dumbList;
    List dumbList2;
    Scanner dumbScanner;
    Function dumbFunction;

    static <T> boolean hasNull(T[] array) {
        return Arrays.stream(array).anyMatch(Objects::isNull);
    }
}