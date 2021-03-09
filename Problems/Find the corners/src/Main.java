class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        final int right = twoDimArray[0].length - 1;
        final int bottom = twoDimArray.length - 1;
        System.out.printf("%d %d\n%d %d", twoDimArray[0][0],
                          twoDimArray[0][right],
                          twoDimArray[bottom][0],
                          twoDimArray[bottom][right]);
    }

//    public static void main(String[] args) {
//        printCorners(new int[][] {
//                {1, 0, 2},
//                {0, 0, 0},
//                {3, 0, 4}
//        });
//    }
}