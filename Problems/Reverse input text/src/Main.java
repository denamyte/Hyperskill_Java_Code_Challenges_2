import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] buffer = new char[1000];
        int readNumber = reader.read(buffer);
        for (int i = readNumber - 1; i >= 0; i--) {
            System.out.print(buffer[i]);
        }
        reader.close();
    }
}