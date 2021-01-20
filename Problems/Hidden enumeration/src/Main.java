import java.util.Arrays;

// A typical stream-driven one-liner...
public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(Secret.values()).map(Enum::name)
                                   .filter(s -> s.startsWith("STAR")).count());
    }
}

//enum Secret {
//    STAR, CRASH, START, // ...
//}
