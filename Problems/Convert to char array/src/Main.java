import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        for (String word : words) {
            writer.write(word);
        }
        return writer.toCharArray();
    }

//    public static void main(String[] args) throws IOException {
//        String[] input = {"This", " ", "is", " ", "a", " ", "test"};
//        System.out.println(Arrays.toString(convert(input)));
//    }
}