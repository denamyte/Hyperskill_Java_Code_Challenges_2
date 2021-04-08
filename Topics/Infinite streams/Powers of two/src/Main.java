import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamUtils {

    Scanner freakingDumpBecauseHyperskillTeamMadeMeToImportThisScanner;
    Collectors freakingDumpBecauseHyperskillTeamMadeMeToImportThisCollectors;

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        return Stream.iterate(1, i -> i * 2).limit(n);
    }
}