import java.io.File;

import java.io.InputStream;

import java.net.URL;
import java.nio.file.Files;

public class HttpStatusImageDownloader {
  static   void downloadStatusImage(int code) throws Exception {
        String path;
         try {
            path = HttpStatusChecker.getStatusImage(code);
             String pathName="web/"+path.substring(17);
             try {
                 URL url = new URL(path);
                 InputStream inputStream = url.openStream();
                 Files.copy(inputStream, new File(pathName).toPath());
             } catch (Exception e) {
                 throw new IllegalArgumentException("***Method-downloadStatusImage- image don't exist !!!");
             }

         } catch (Exception e) {
              throw new RuntimeException(e);
         }
  }
}
