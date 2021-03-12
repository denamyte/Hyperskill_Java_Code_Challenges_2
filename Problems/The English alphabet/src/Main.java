class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder sb = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            sb.append(c).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}