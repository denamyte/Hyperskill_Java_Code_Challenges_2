import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 3)
                .forEach(v -> System.out.printf("Implemented do%d%n", v));
//
//        ThreeMethodsInterface instance = new ThreeMethodsInterface() {
//            @java.lang.Override
//            public void do1() {
//                System.out.println("Implemented do1");
//            }
//
//            @java.lang.Override
//            public void do2() {
//                System.out.println("Implemented do2");
//            }
//
//            @java.lang.Override
//            public void do3() {
//                System.out.println("Implemented do3");
//            }
//        };
//
//        instance.do1();
//        instance.do2();
//        instance.do3();
    }
}

//interface ThreeMethodsInterface {
//
//    void do1();
//
//    void do2();
//
//    void do3();
//}