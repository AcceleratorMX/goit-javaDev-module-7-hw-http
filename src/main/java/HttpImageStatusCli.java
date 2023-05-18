import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        int code;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter HTTP status code: ");
                code = scanner.nextInt();
                downloader.downloadStatusImage(code);
                System.out.println("Image downloaded successfully.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        scanner.close();
    }
}
