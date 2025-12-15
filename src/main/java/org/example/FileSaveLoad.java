package org.example;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaveLoad {
    public static JSONObject loadJson (String filePath)throws IOException{
        String content =  Files.readString(Path.of(filePath));
        return new JSONObject(content);
    }
    public static void saveJson(String filePath, JSONObject json) throws IOException {
        Files.writeString(
                Path.of(filePath),
                json.toString(4) // 4 = hübsch eingerückt
        );
    }
}


