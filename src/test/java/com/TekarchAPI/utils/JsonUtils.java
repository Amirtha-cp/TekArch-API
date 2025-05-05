package com.TekarchAPI.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import com.jayway.jsonpath.JsonPath;

public class JsonUtils {
//TO rad entire fila as byte array and return as String 
    public static String readJsonFileToString(String filePath) throws IOException {
        byte[] jsonData = Files.readAllBytes(Path.of(filePath));
        return new String(jsonData, StandardCharsets.UTF_8); //  specify UTF-8 charset
    }
// To parese the JSON file read as byte array 
    public static Object readTestDataFromJsonString(String filePath, String jsonPath) throws IOException {
        String dataFromFile = readJsonFileToString(filePath);
        return JsonPath.read(dataFromFile, jsonPath);
    }
}

