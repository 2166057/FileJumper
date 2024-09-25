package net.wattpadpremium.filejumper.builders;

import com.google.gson.*;
import net.wattpadpremium.filejumper.filemodificator.JsonFileModificator;
import net.wattpadpremium.filejumper.task.JsonJumperTask;
import net.wattpadpremium.filejumper.utilities.FilePathCreationTool;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonFileJumper {
    private JsonObject jsonObject;
    private final File file;

    public JsonFileJumper(File file) {
        this.file = file;
        FilePathCreationTool.createMissingFileAndFolders(file);
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

    public void editWithTemplate(JsonJumperTask runnable){
        runnable.editTemplate(new JsonFileModificator(this.jsonObject,true));
        save();
    }

    public JsonFileModificator getJsonFileModificator() {
        return new JsonFileModificator(jsonObject,false);
    }

    public void save() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(jsonObject);
            Files.writeString(file.toPath(), json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
