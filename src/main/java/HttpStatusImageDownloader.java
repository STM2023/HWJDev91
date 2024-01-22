import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

public class HttpStatusImageDownloader {
  static   void downloadStatusImage(int code) throws IllegalArgumentException {
        String path;
         try {
            path = HttpStatusChecker.getStatusImage(code);
             if(path.substring(17,20).equals("404")){
                  throw new IllegalArgumentException("***Method-downloadStatusImage- image don't exist !!!");
             }
             String pathName="web/"+path.substring(17);
             try {
                 URL url = new URL(path);
                 InputStream inputStream = url.openStream();
                 Files.copy(inputStream, new File(pathName).toPath());
             } catch (Exception e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
            e.printStackTrace();
         }

    }
}
