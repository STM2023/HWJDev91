import java.io.File;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final  Scanner scanner = new Scanner(System.in);
    private static  int input()  {
        int   input= 0;
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter valid number");
            }

            scanner.close();
            return input;
    }

   public static void askStatus()   {
       int inputcode =0;

           System.out.println("Enter HTTP status code");
           inputcode = input();

       String filepath ="web/"+inputcode+".jpg";
       File file = new File(filepath);
       if (file.exists()) {
           file.delete();
       }
         try {
             HttpStatusImageDownloader.downloadStatusImage(inputcode);
         }  catch(Exception e){
                 System.out.println(e.getMessage());
         }

           file = new File(filepath);
           if (!file.exists()) {
                 System.out.println("There is not image for HTTP status "+inputcode);
           }
    }
}
