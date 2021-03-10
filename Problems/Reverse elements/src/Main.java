class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        final int length = twoDimArray[0].length;
        for (int[] inner : twoDimArray) {
            for (int i = 0; i < length / 2; i++) {
                final int opp = length - i - 1;
                int temp = inner[i];
                inner[i] = inner[opp];
                inner[opp] = temp;
            }
        }
    }
}