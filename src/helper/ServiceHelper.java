package helper;

import util.InputUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

import static data.GlobalData.filePath;
import static data.GlobalData.words;

public class ServiceHelper {

    public static void createDirectoryAndFile() {
        Path directory = Paths.get("files");
        try {
            Files.createDirectory(directory);
            Files.createFile(filePath);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String getKeyValue(Map<String, String> getKeyValue) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : getKeyValue.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            result.append(key).append(" - ").append(value).append("\n");
        }

        return result.toString();
    }

    public static int playGame(LinkedHashMap<String, String> wordsMap, Function<Map.Entry<String, String>, Boolean> answerCheck) {
        int point = 0;

        if (wordsMap == null) {
            System.out.println("An error occurred while reading the file.");
            return point;
        }

        Random random = new Random();
        List<Map.Entry<String, String>> wordEntries = new ArrayList<>(wordsMap.entrySet());
        Collections.shuffle(wordEntries,random);

        for (int i = 0; i < 10 ; i++) {
            Map.Entry<String, String> randomEntry = wordEntries.get(i);

            if (answerCheck.apply(randomEntry)) {
                point++;
            }
        }

        return point;
    }

    public static String playerAnswer(String word) {
        return InputUtil.getInstance().inputString(word);
    }

    public static boolean isAnswerTrueAze(Map<String, String> word) {
        String value = word.values().iterator().next();
        String playerAnswer = playerAnswer(word.keySet().iterator().next() + ": ");
        return playerAnswer.equals(value);
    }
    public static boolean isAnswerTrueEng(Map<String, String> word) {
        String key = word.keySet().iterator().next();
        String playerAnswer = playerAnswer(word.values().iterator().next() + ": ");
        return playerAnswer.equals(key);
    }

    public static List<String> randomWord (){
        if (words == null) {
            throw new RuntimeException("An error occurred while reading the file.");
        }
        List<String> wordKeys = new ArrayList<>(words.keySet());
        Collections.shuffle(wordKeys);
        return wordKeys;
    }

    public static Map<String,String> randomMap (List<String> wordKeys, int i){
        String randomKey = wordKeys.get(i);
        String randomValue = words.get(randomKey);
        Map<String,String> randomMap = new HashMap<>();
        randomMap.put(randomKey,randomValue);
        return randomMap;
    }


}

