class Seven {
    public static SeptenaryStringFunction fun = (s1, s2, s3, s4, s5, s6, s7) ->
            String.join("", s1, s2, s3, s4, s5, s6, s7).toUpperCase();

//    public static void main(String[] args) {
//        String[] a = new Scanner(System.in).tokens().limit(7).toArray(String[]::new);
//        System.out.println(fun.apply(a[0], a[1], a[2], a[3], a[4], a[5], a[6]));
//    }
}

@FunctionalInterface
interface SeptenaryStringFunction {
    String apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}