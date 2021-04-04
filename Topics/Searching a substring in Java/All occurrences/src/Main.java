import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String pattern = scanner.nextLine();
        final String text = scanner.nextLine();
        final List<Integer> occurrences = searchOccurrences(text, pattern);
        System.out.println(occurrences.size());
        if (!occurrences.isEmpty()) {
            System.out.println(occurrences.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    public static List<Integer> searchOccurrences(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return List.of();
        } else if (pattern.isEmpty()) {
            return List.of(0);
        }
        List<Integer> indices = new LinkedList<>();

        final int count = text.length() - pattern.length() + 1;
        for (int i = 0; i < count; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound) {
                indices.add(i);
            }
        }

        return indices;
    }
}