package net.wattpadpremium.filejumper.builders;

import com.google.gson.*;
import net.wattpadpremium.filejumper.JsonFileModification;
import net.wattpadpremium.filejumper.abstraction.JsonTask;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonFileCreator {

    private JsonObject jsonObject;

    private final File file;

    private JsonFileCreator(File file) {
        this.file = file;
        createMissingDirectories();
        try {
            String fileContent = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileContent);
            if (jsonElement.isJsonObject()) {
                jsonObject = jsonElement.getAsJsonObject();
            }
            if (jsonElement.isJsonNull()) {
                jsonObject = new JsonObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void editWithTemplate(JsonTask runnable){
        runnable.editTemplate(new JsonFileModification(this.jsonObject));
        saveToFile();
    }

    public static JsonFileCreator createJsonFile(File file) {
        return new JsonFileCreator(file);
    }

    private void saveToFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(jsonObject);
            Files.writeString(file.toPath(), json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createMissingDirectories() {
        if (!file.exists()) {
            String s = file.getParent();
            File folders = new File(s);
            if (!folders.exists()){
                folders.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
