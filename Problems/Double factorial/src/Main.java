import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // OK, code reviewer, OK...
        int nThatCanBeReassignable = n;
        BigInteger result = BigInteger.ONE;
        while (nThatCanBeReassignable > 0) {
            result = result.multiply(BigInteger.valueOf(nThatCanBeReassignable));
            nThatCanBeReassignable -= 2;
        }
        return result;
    }
}