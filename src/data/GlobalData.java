package data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GlobalData {
    public static final Path filePath = Paths.get("files\\word.txt");
    public static Map<String,String> words = new HashMap<>();
}
