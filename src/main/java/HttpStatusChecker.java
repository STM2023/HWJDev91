
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    static String getStatusImage(int code) throws Exception{
        String path ="https://http.cat/"+code;
        HttpRequest request = HttpRequest.newBuilder(new URI(path)).build();
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            path =path +".jpg";
            if(response.statusCode()==404){
              throw new IllegalArgumentException("***Method- getStatusImage- response.statusCode() = 404 !!!");
            }
        return path;
    }
}
