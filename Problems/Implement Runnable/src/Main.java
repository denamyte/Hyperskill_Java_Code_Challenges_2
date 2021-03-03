class Create {

    public static Runnable createRunnable(String text, int repeats) {
        return new Runnable() {
            @Override
            public void run() {
                int n = repeats;
                while (n-- > 0) {
                    System.out.println(text);
                }
            }
        };
    }
}