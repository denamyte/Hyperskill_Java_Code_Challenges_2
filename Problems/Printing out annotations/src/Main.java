import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

class AnnotationUtils {

    public static void printAnnotations(Class classObject) {
        List<Annotation> aList = new LinkedList<>();
        collectAnnotations(classObject::getDeclaredAnnotations, aList);
        for (Field field : classObject.getDeclaredFields()) {
            collectAnnotations(field::getDeclaredAnnotations, aList);
        }
        for (Method method : classObject.getDeclaredMethods()) {
            collectAnnotations(method::getDeclaredAnnotations, aList);
        }
        aList.stream()
                .map(Annotation::annotationType)
                .map(Class::getSimpleName)
                .distinct()
                .forEach(System.out::println);
    }

    public static void collectAnnotations(Supplier<Annotation[]> annGetter, List<Annotation> annList) {
        annList.addAll(List.of(annGetter.get()));
    }

}