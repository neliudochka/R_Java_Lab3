public class Main {
    public static void main(String[] args) {
        String text = "One Two, 3, la four, five what? One Two, 3, la four, five. ";
        StringBuilder s = new StringBuilder(text);

        try {
            System.out.println(MyExecutor.exec(new StringBuilder(s)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
