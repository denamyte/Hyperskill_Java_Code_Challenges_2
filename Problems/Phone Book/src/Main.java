import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    // You gave me a F*CkOff description, I gave you a brut force solution ;)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cmdCount = Integer.parseInt(scanner.nextLine());
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        for (int i = 0; i < cmdCount; i++) {
            String[] ar = scanner.nextLine().split("\\W+");
            switch (ar[0]) {
                case "put":
                    hashtable.put(Integer.parseInt(ar[1]), ar[2]);
                    break;
                case "get":
                    String value = hashtable.get(Integer.parseInt(ar[1]));
                    System.out.println(value == null ? "-1" : value);
                    break;
                case "remove":
                    hashtable.remove(Integer.parseInt(ar[1]));
                    break;
                default:
                    break;
            }
        }
    }
}