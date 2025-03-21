package Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class RandomWordManager {
    static String apiUrl = "https://random-word-api.herokuapp.com/all?lang=zh";

        public static String getRandomWord() {
            try {
                // Die URL der API
                String apiUrl = "https://random-word-api.herokuapp.com/word?number=42";

                // Erstelle ein URL-Objekt
                URL url = new URL(apiUrl);

                // Öffne eine Verbindung zur API
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET"); // GET-Methode verwenden
                connection.setConnectTimeout(5000); // Timeout setzen
                connection.setReadTimeout(5000); // Timeout setzen

                // Stelle sicher, dass die Antwortcode 200 OK ist
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Lese die Antwort der API
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Gib die Antwort aus
                    System.out.println("API Antwort: " + response.toString());
                } else {
                    System.out.println("Fehler: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

}

