

class Problem {
    public static void main(String[] args) {
        int argsRead = 0;
        while (args.length > argsRead) {
            System.out.printf("%s=%s%n", args[argsRead++], args[argsRead++]);
        }
    }
}