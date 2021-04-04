// You can experiment here, it won’t be checked

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
        final IntSummaryStatistics summ = IntStream.empty().summaryStatistics();
        System.out.println(summ);
    }
}
