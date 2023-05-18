import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage(int code) {

        try {
            String url = "https://http.cat/" + code + ".jpg";

            Connection.Response response = Jsoup.connect(url).
                    ignoreContentType(true).
                    execute();

            if (!(response.statusCode() == 200)){
                throw new RuntimeException(response.statusCode() + " - image not found.");
            }
            return url;
        } catch (IOException e) {
            throw new RuntimeException("Connection error: " + e.getMessage());
        }
    }
}
