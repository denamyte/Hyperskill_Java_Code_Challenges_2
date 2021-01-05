import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vec a = new Vec(scanner.nextInt(), scanner.nextInt());
        Vec b = new Vec(scanner.nextInt(), scanner.nextInt());
        System.out.println(Vec.angle(a, b));
    }

    static class Vec {
        int x;
        int y;

        Vec(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static double product(Vec a, Vec b) {
            return a.x * b.x + a.y * b.y;
        }

        static double scalarProduct(Vec a, Vec b) {
            return Math.hypot(a.x, a.y) * Math.hypot(b.x, b.y);
        }

        static int angle(Vec a, Vec b) {
            double cos = product(a, b) / scalarProduct(a, b);
            return (int) Math.round(Math.toDegrees(Math.acos(cos)));
        }
    }
}