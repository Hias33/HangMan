package Data;
//intern:
import Models.Difficulty;

//extern:
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class RandomWordManager {

        public static List<String> getRandomWord(Difficulty pDifficulty) {
            List<String> wordList = new ArrayList<>();
            switch(pDifficulty){
                case Easy -> {
                    apiUrl = "https://loudly-organic-osprey.ngrok-free.app/Word?lang=de&number=100&min=7&max=10";
                    wordList = SendRequest(apiUrl);
                }
                case Medium -> {
                    apiUrl = "https://loudly-organic-osprey.ngrok-free.app/Word?lang=en&number=100&min=6&max=9";
                    wordList = SendRequest(apiUrl);
                }
                case Hard -> {
                    apiUrl = "https://loudly-organic-osprey.ngrok-free.app/Word?lang=it&number=100&min=3&max=5";
                    wordList = SendRequest(apiUrl);
                }
            }

            return wordList;
        }

        private static List<String> SendRequest(String pApiUrl){
            try {
                URL url = new URL(pApiUrl);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String inputLine;
                    inputLine = in.readLine();

                    String rawResponse = inputLine.toString().trim();
                    rawResponse = rawResponse.substring(1,rawResponse.length() - 1);

                    String cleanedInput = rawResponse.replace("\"words\":[", "")
                            .replace("[", "")
                            .replace("]", "")
                            .replace("\"", "");


                    String[] wordsArray = cleanedInput.split(",");
                    List<String> response = new ArrayList<>();

                    for (String word : wordsArray){
                        if(!(word).toLowerCase().contains("ä")&&!(word).toLowerCase().contains("ö")&&!(word).toLowerCase().contains("ü")) {
                            response.add(word.replace("\"", "").trim());
                        }
                    }
                    in.close();

                    return response.stream().toList();

                } else {
                    System.out.println("Fehler: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    private static String apiUrl = "";
}

