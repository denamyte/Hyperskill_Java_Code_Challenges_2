import java.lang.reflect.*;
import java.util.*;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .map(Field::getName)
                .sorted().toArray(String[]::new);
    }

//    public static void main(String[] args) {
//        Arrays.stream(new FieldGetter().getPublicFields(new Example()))
//                .forEach(System.out::println);
//    }
//
//    static class Example {
//        public String b;
//        public String h;
//        public String g;
//        public String e;
//        public String c;
//        public int a;
//        public String f;
//        public String d;
//    }
}