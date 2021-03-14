import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

class ReflectionUtils {

    public static int countPublicMethods(Class<?> targetClass) {
        Collection<Method> decMeth = Arrays.stream(targetClass.getDeclaredMethods()).collect(Collectors.toList());
        return (int) Arrays.stream(targetClass.getMethods()).filter(decMeth::contains).count();
    }
}