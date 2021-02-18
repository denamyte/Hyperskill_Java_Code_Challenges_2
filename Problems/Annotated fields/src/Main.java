import java.lang.reflect.Field;
import java.util.Arrays;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotations().length > 0)
                .map(Field::getName)
                .toArray(String[]::new);
    }

//    static class TestClass {
//        @Deprecated
//        private static int deprecatedInt;
//        public int usualInt;
//        @Deprecated
//        protected int deprecatedInt2;
//    }
//
//    public static void main(String[] args) {
//        final TestClass instance = new TestClass();
//        System.out.println(Arrays.toString(AnnotationsUtil.getFieldsContainingAnnotations(instance)));
//    }
}