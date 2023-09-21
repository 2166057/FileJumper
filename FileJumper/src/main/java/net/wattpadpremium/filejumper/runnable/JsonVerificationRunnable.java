package net.wattpadpremium.filejumper.runnable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.wattpadpremium.filejumper.JsonFileJumper;

public abstract class JsonVerificationRunnable {
    private JsonFileJumper jsonFileJumper;
    public void run(JsonFileJumper jsonFileJumper){
        this.jsonFileJumper = jsonFileJumper;
        editTemplate(jsonFileJumper);
    }
    protected abstract void editTemplate(JsonFileJumper fileJumper);
    private JsonObject getJson(){
        return jsonFileJumper.getJson();
    }
    protected int check(String key, int defaultValue){
        if (getJson().get(key) != null){
            Integer value = getJson().get(key).getAsInt();
            if (value != null){
                System.out.println(key + " is set to " + value);
                return value;
            }
        }
        System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
        getJson().addProperty(key,defaultValue);
        return defaultValue;
    }

    protected boolean check(String key,boolean defaultValue){
        if (getJson().get(key) != null){
            Boolean value = getJson().get(key).getAsBoolean();
            if (value != null){
                System.out.println(key + " is set to " + value);
                return value;
            }
        }
        System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
        getJson().addProperty(key,defaultValue);
        return defaultValue;
    }

    protected String check(String key,String defaultValue){
        if (getJson().get(key) != null) {
            String value = getJson().get(key).getAsString();
            if (value != null) {
                System.out.println(key + " is set to " + value);
                return value;
            }
        }
        System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
        getJson().addProperty(key,defaultValue);
        return defaultValue;
    }

    protected JsonObject check(String key, JsonObject defaultValue){
        if (getJson().get(key) != null){
            JsonObject value = getJson().get(key).getAsJsonObject();
            if (value != null){
                System.out.println(key + " is set to " + value);
                return value;
            }
        }
        System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
        getJson().add(key,defaultValue);
        return defaultValue;
    }

    protected double check(String key, double defaultValue){
        if (getJson().get(key) != null){
            Double value = getJson().get(key).getAsDouble();
            if (value != null){
                System.out.println(key + " is set to " + value);
                return value;
            }
        }
        System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
        getJson().addProperty(key,defaultValue);
        return defaultValue;
    }

    protected double checkNestedDoubleValue(String key, double defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonPrimitive() && valueElement.getAsJsonPrimitive().isNumber()) {
                double value = valueElement.getAsDouble();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.addProperty(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }

    protected String checkNestedStringValue(String key, String defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonPrimitive() && valueElement.getAsJsonPrimitive().isString()) {
                String value = valueElement.getAsString();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.addProperty(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }

    protected int checkNestedIntegerValue(String key, int defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonPrimitive() && valueElement.getAsJsonPrimitive().isNumber()) {
                int value = valueElement.getAsInt();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.addProperty(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }

    protected boolean checkNestedBooleanValue(String key, boolean defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonPrimitive() && valueElement.getAsJsonPrimitive().isBoolean()) {
                boolean value = valueElement.getAsBoolean();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.addProperty(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }

    protected JsonObject checkNestedJsonObjectValue(String key, JsonObject defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonObject()) {
                JsonObject value = valueElement.getAsJsonObject();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.add(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }
    protected JsonArray checkNestedJsonArrayValue(String key, JsonArray defaultValue) {
        JsonObject jsonObject = getJson();
        String[] nests = key.split("\\.");

        for (int index = 0; index < nests.length - 1; index++) {
            String nestedKey = nests[index];
            if (jsonObject.has(nestedKey)) {
                JsonElement element = jsonObject.get(nestedKey);
                if (element.isJsonObject()) {
                    jsonObject = element.getAsJsonObject();
                } else {
                    // Handle case where a non-object value exists for the nested key
                    // You can choose to throw an exception or handle it differently based on your requirements
                    throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
                }
            } else {
                JsonObject newObj = new JsonObject();
                jsonObject.add(nestedKey, newObj);
                jsonObject = newObj;
            }
        }

        String finalKey = nests[nests.length - 1];
        if (jsonObject.has(finalKey)) {
            JsonElement valueElement = jsonObject.get(finalKey);
            if (valueElement.isJsonArray()) {
                JsonArray value = valueElement.getAsJsonArray();
                System.out.println(finalKey + " is set to " + value);
                return value;
            }
        } else {
            // Write a new value to the file if the key is not present
            jsonObject.add(finalKey, defaultValue);
            System.out.println("Created new entry for " + key + " with a value of " + defaultValue);
            return defaultValue;
        }

        throw new IllegalArgumentException("Invalid nested JSON structure for key: " + key);
    }

}
