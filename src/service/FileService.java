package service;
import response.GeneralResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public interface FileService {
    GeneralResponse<String> writeFile(Map<String,String> word);
    Map<String, String> reedFile();
}
