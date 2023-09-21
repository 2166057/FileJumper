package net.wattpadpremium.filejumper;

import com.google.gson.*;
import lombok.Getter;
import net.wattpadpremium.filejumper.runnable.JsonVerificationRunnable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileJumper extends BaseFileJumper{

    @Getter
    private JsonObject json;
    public JsonFileJumper(File file) {
        super(file);
        json = new GsonBuilder().create().fromJson(getFileReader(),JsonObject.class);
        if (json == null){
            json = new JsonObject();
        }
    }
    public JsonFileJumper(File file,JsonVerificationRunnable verificationRunnable) {
        this(file);
        verificationRunnable.run(this);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(json);
        // Write JSON string to a file
        try {
            getFileWriter().write(jsonString);
            getFileWriter().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            getFileReader().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeJsonIntegerToFile(String key, int value) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            JsonObject newNestedObject = new JsonObject();
            nestedObject.add(nestedKey, newNestedObject);
            nestedObject = newNestedObject;
        }

        String finalKey = nests[nests.length - 1];
        nestedObject.addProperty(finalKey, value);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("Integer value written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonStringToFile(String key, String value) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            if (nestedObject.has(nestedKey) && nestedObject.get(nestedKey).isJsonObject()) {
                nestedObject = nestedObject.getAsJsonObject(nestedKey);
            } else {
                JsonObject newNestedObject = new JsonObject();
                nestedObject.add(nestedKey, newNestedObject);
                nestedObject = newNestedObject;
            }
        }

        String finalKey = nests[nests.length - 1];
        nestedObject.addProperty(finalKey, value);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("String value written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonDoubleToFile(String key, double value) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            if (nestedObject.has(nestedKey) && nestedObject.get(nestedKey).isJsonObject()) {
                nestedObject = nestedObject.getAsJsonObject(nestedKey);
            } else {
                JsonObject newNestedObject = new JsonObject();
                nestedObject.add(nestedKey, newNestedObject);
                nestedObject = newNestedObject;
            }
        }

        String finalKey = nests[nests.length - 1];
        nestedObject.addProperty(finalKey, value);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("Double value written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonArrayToFile(String key, JsonElement[] values) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            if (nestedObject.has(nestedKey) && nestedObject.get(nestedKey).isJsonObject()) {
                nestedObject = nestedObject.getAsJsonObject(nestedKey);
            } else {
                JsonObject newNestedObject = new JsonObject();
                nestedObject.add(nestedKey, newNestedObject);
                nestedObject = newNestedObject;
            }
        }

        String finalKey = nests[nests.length - 1];
        JsonArray jsonArray = new JsonArray();
        for (JsonElement value : values) {
            jsonArray.add(value);
        }
        nestedObject.add(finalKey, jsonArray);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("Array written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonBooleanToFile(String key, boolean value) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            if (nestedObject.has(nestedKey) && nestedObject.get(nestedKey).isJsonObject()) {
                nestedObject = nestedObject.getAsJsonObject(nestedKey);
            } else {
                JsonObject newNestedObject = new JsonObject();
                nestedObject.add(nestedKey, newNestedObject);
                nestedObject = newNestedObject;
            }
        }

        String finalKey = nests[nests.length - 1];
        nestedObject.addProperty(finalKey, value);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("Boolean value written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonObjectToFile(String key, JsonObject value) {
        JsonObject jsonObject = getJson();

        String[] nests = key.split("\\.");

        JsonObject nestedObject = jsonObject;
        for (int i = 0; i < nests.length - 1; i++) {
            String nestedKey = nests[i];
            if (nestedObject.has(nestedKey) && nestedObject.get(nestedKey).isJsonObject()) {
                nestedObject = nestedObject.getAsJsonObject(nestedKey);
            } else {
                JsonObject newNestedObject = new JsonObject();
                nestedObject.add(nestedKey, newNestedObject);
                nestedObject = newNestedObject;
            }
        }

        String finalKey = nests[nests.length - 1];
        nestedObject.add(finalKey, value);

        try (FileWriter fileWriter = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, fileWriter);
            System.out.println("JsonObject written to JSON file: " + getFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
