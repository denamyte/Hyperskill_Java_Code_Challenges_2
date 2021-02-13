import java.util.Arrays;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (String name : classNames) {
            if (Arrays.stream(Class.forName(name).getMethods())
                    .anyMatch(method -> methodName.equals(method.getName()))) {
                return name;
            }
        }
        return null;
    }
}