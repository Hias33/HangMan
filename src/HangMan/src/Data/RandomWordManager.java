package Data;
import Models.Difficulty;
import Models.Language;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class RandomWordManager {
    static String apiUrl = "https://random-word-api.herokuapp.com/all?lang=zh";

        public static List<String> getRandomWord(Difficulty pDifficulty) {
            List<String> wordList = new ArrayList<>();

            switch(pDifficulty){
                case Difficulty.Easy -> {
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=de&number=100&length=5";
                    wordList = SendRequest(apiUrl);
                }
                case Difficulty.Medium -> {
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=de&number=50&length=8";
                    wordList = SendRequest(apiUrl);
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=en&number=50&length=8";
                    for(String word : SendRequest(apiUrl)){
                        wordList.add(word);
                    }
                }
                case Difficulty.Hard -> {
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=de&number=33&length=8";
                    wordList = SendRequest(apiUrl);
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=en&number=33&length=8";
                    for(String word : SendRequest(apiUrl)){
                        wordList.add(word);
                    }
                    apiUrl = "https://random-word-api.herokuapp.com/word?lang=it&number=34&length=8";
                    for(String word : SendRequest(apiUrl)){
                        wordList.add(word);
                    }
                }
            }
            return null;
        }

        public static List<String> GetCustomDifficultyWord(List<Language> pLanguages, int pWordLength){
            List<String> wordList = new ArrayList<>();
            for(Language language : pLanguages){
                apiUrl = "https://random-word-api.herokuapp.com/word?lang="+language.language+"&number="+language.probability+"&length="+pWordLength;
                for(String word : SendRequest(apiUrl)){
                    wordList.add(word);
                }
            }
            return wordList;
        };

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

                    String[] wordsArray = rawResponse.split(",");

                    List<String> response = new ArrayList<>();

                    for (String word : wordsArray){
                        response.add(word.replace("\"","").trim());
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

}

