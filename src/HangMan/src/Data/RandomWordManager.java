package Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class RandomWordManager {
    static String apiUrl = "https://random-word-api.herokuapp.com/all?lang=zh";

        public static List<String> getRandomWord() {
            try {
                // Die URL der API
                String apiUrl = "https://random-word-api.herokuapp.com/word?lang=de";

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
                    inputLine = in.readLine();

                    String rawResponse = inputLine.toString().trim();
                    rawResponse = rawResponse.substring(1,rawResponse.length() - 1);

                    String[] wordsArray = rawResponse.split(",");

                    List<String> response = new ArrayList<>();

                    for (String word : wordsArray){
                        response.add(word.replace("\"","").trim());
                    }

                    in.close();

                    // Gib die Antwort aus
                    return response.stream().toList();

                } else {
                    System.out.println("Fehler: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

}

