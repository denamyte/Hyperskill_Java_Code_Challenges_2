import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

class Operator {

    public static LongBinaryOperator mult = (x, y) -> x * y;
    public static LongBinaryOperator binaryOperator =
        (x, y) -> LongStream.rangeClosed(x, y).reduce(1, mult);

//    public static void main(String[] args) {
//        System.out.println(binaryOperator.applyAsLong(0,1));
//        System.out.println(binaryOperator.applyAsLong(2,2));
//        System.out.println(binaryOperator.applyAsLong(1,4));
//        System.out.println(binaryOperator.applyAsLong(5,15));
//    }
}