import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Represents inclusive integer range.
 */
class Range implements Serializable {

    private static final long serialVersionUID = 1L;

    /** @serial */
    private final int from;
    /** @serial */
    private final int to;

    /**
     * Creates Range.
     *
     * @param from start
     * @param to   end
     * @throws IllegalArgumentException if start is greater than end.
     */
    public Range(int from, int to) {
        checkConstraints(from, to);
        this.from = from;
        this.to = to;
    }

    private static void checkConstraints(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        checkConstraints(from, to);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

}