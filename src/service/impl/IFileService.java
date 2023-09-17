package service.impl;

import response.GeneralResponse;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

import static data.GlobalData.filePath;
import static helper.ServiceHelper.createDirectoryAndFile;
import static helper.ServiceHelper.getKeyValue;

public class IFileService implements FileService{
    @Override
    public GeneralResponse<String> writeFile(Map<String, String> word) {
        if (!Files.exists(filePath)) {
            createDirectoryAndFile();
        }
        try {
            String keyValue = getKeyValue(word);
            Files.writeString(filePath,keyValue, StandardOpenOption.APPEND);
            return new GeneralResponse<String>().of(201,"Word file successfully write!",keyValue);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return new GeneralResponse<String>().of(500,"Word file wrong write!");
    }

    @Override

    public Map<String, String> reedFile() {
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            String fileContent = new String(bytes);

            String[] lines = fileContent.split("\n");
            Map<String, String> words = new LinkedHashMap<>();

            for (String line : lines) {
                String[] keyAndValue = line.split(" - ");

                words.put(keyAndValue[0], keyAndValue[1]);
            }
            return words;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
