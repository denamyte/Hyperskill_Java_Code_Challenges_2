import java.util.Iterator;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        return new LongIterator(fromInclusive, toExclusive);
    }

    public static void main(String[] args) {
        Range r = new Range(2, 6);
        for (long value: r) {
            System.out.println(value);
        }
    }

}

class LongIterator implements Iterator<Long> {

    private long current;
    private final long to;

    LongIterator(long current, long to) {
        this.to = to;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current < to;
    }

    @Override
    public Long next() {
        return current++;
    }
}