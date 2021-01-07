class Problem {
    public static void main(String[] args) {
        System.out.println(getModeValue(args));
    }

    private static String getModeValue(String[] args) {
        int argsRead = 0;
        while (args.length > argsRead) {
            if ("mode".equals(args[argsRead++])) {
                return args[argsRead];
            }
            argsRead++;
        }
        return "default";
    }
}