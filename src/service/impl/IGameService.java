package service.impl;

import response.GeneralResponse;
import service.FileService;
import service.GameService;
import util.InputUtil;

import java.util.*;

import static data.GlobalData.words;
import static helper.ServiceHelper.*;

public class IGameService implements GameService {

    private final FileService fileService;

    public IGameService() {
        this.fileService = new IFileService();
        words = fileService.reedFile();
    }

    public void playEngToAze() {
        int point = 0;
        List<String> wordKeys = randomWord();
        for (int i = 0; i < 10 && i < wordKeys.size(); i++) {
            Map<String, String> randomMap = randomMap(wordKeys, i);
            if (isAnswerTrueAze(randomMap)) {
                point++;
            }
        }
        System.out.println("Your point: " + point);
    }

    @Override
    public void playAzeToEng() {
        int point = 0;
        List<String> wordKeys = randomWord();
        for (int i = 0; i < 10 && i < wordKeys.size(); i++) {
            Map<String, String> randomMap = randomMap(wordKeys, i);
            if (isAnswerTrueEng(randomMap)) {
                point++;
            }
        }
        System.out.println("Your point: " + point);

    }

    @Override
    public void show() {
        Map<String,String> words =fileService.reedFile();
        System.out.println("----------------| Words |----------------");
        System.out.println(words);
        System.out.println("-----------------------------------------");
    }

    @Override
    public GeneralResponse<String> add() {
        String key = InputUtil.getInstance().inputString("Eng: ");
        String value = InputUtil.getInstance().inputString("Az: ");
        LinkedHashMap<String, String> word = new LinkedHashMap<>();
        word.put(key,value);
        return fileService.writeFile(word);
    }
}
