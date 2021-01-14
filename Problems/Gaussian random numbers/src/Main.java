import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(new GaussianRnd(
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextDouble()
            ).seed);
        }
    }
}

class GaussianRnd {
    int seed;
    int n;
    double m;

    public GaussianRnd(int k, int n, double m) {
        this.seed = k;
        this.n = n;
        this.m = m;
        while (!test()) {
            seed++;
        }
    }

    final boolean test() {
        Random rnd = new Random(seed);
        for (int i = 0; i < n; i++) {
            if (rnd.nextGaussian() > m) {
                return false;
            }
        }
        return true;
    }
}

