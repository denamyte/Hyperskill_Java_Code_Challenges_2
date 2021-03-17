import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<>() {
            private int value;

            @Override
            public Integer get() {
                return value++;
            }
        };
    }
}