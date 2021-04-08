import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        System.out.println(map1.entrySet().stream()
                                   .filter(entry -> entry.getValue().equals(map2.get(entry.getKey())))
                                   .count());
    }
}
