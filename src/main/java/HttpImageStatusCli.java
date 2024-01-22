import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final Scanner scanner = new Scanner(System.in);
    private static  int input() throws InputMismatchException {
            int input=0;

            try {
                 input = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }

            if (input > 0 && input < 100000) {
                    return  input;
            } else {
                System.out.println("Invalid input. Please enter valid number");
            }

            return  input;
    }

   public static void askStatus()   throws IllegalArgumentException{
       int inputcode =0;
       System.out.println("Enter HTTP status code");
       try {   inputcode =input();
       } catch (Exception e) {
           e.printStackTrace();
       }

       File file = new File("web/404.jpg");
       if (file.exists()) {
           file.delete();
       }
         try {
           HttpStatusImageDownloader.downloadStatusImage(inputcode);
         } catch (Exception e) {
           e.printStackTrace();
         }
           String filepath ="web/"+inputcode+".jpg";
           file = new File(filepath);
           if (!file.exists()) {
                 System.out.println("There is not image for HTTP status "+inputcode);
           }

    }
}
