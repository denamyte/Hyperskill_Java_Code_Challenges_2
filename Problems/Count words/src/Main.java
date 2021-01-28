import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine().trim();
            System.out.println(s.isEmpty() ? 0 : s.split("\\s+").length);
        }
    }
}