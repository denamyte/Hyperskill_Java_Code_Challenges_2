class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] ar = new int[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    ar[i][j][k] = j * 3 + k;
                }
            }
        }
        return ar;
    }

//    public static void main(String[] args) {
//        test();
//    }

    private static void test() {
        final int[][][] x = createCube();
        for (int[][] y : x) {
            for (int[] z : y) {
                System.out.printf("[%d,%d,%d]  ", z[0], z[1], z[2]);
            }
            System.out.println();
        }
    }
}