import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditDistanceAlignmentWithCustomScoring eda = new EditDistanceAlignmentWithCustomScoring(2, 3);
        Scanner scanner = new Scanner(System.in);
        System.out.println(eda.calcAlignment(scanner.nextLine(), scanner.nextLine()));
    }
}

class EditDistanceAlignmentWithCustomScoring {
    private final int insScore;
    private final int subScore;

    public EditDistanceAlignmentWithCustomScoring(int insScore, int subScore) {
        this.insScore = insScore;
        this.subScore = subScore;
    }

    private int match(char a, char b) {
        return (a == b) ? 0 : subScore;
    }

    public Alignment calcAlignment(String s, String t) {
        int[][] d = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            d[i][0] = insScore * i;
        }

        for (int j = 0; j < t.length() + 1; j++) {
            d[0][j] = insScore * j;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = d[i][j - 1] + insScore;
                int delCost = d[i - 1][j] + insScore;
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }
        return reconstructAlignment(d, s, t);
    }

    private Alignment reconstructAlignment(int[][] d, String s, String t) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && d[i][j] == d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1))) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                i -= 1;
                j -= 1;
            } else if (j > 0 && d[i][j] == d[i][j - 1] + insScore) {
                ssBuilder.append("-");
                ttBuilder.append(t.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && d[i][j] == d[i - 1][j] + insScore) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();

        return new Alignment(d[s.length()][t.length()], ss, tt);
    }
}

class Alignment {
    public int editDistance;
    public String source;
    public String target;

    public Alignment(int editDist, String source, String target) {
        this.editDistance = editDist;
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString() {
        return String.format("%d%n%s%n%s", editDistance, source, target);
    }
}

