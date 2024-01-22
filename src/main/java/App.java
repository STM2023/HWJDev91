

public class App {
    public static void main(String[] args)  {
        try {
            HttpImageStatusCli.askStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}