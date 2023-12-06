package net.wattpadpremium.filejumper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonFileModification {
    private final JsonObject jsonObject;
    public JsonFileModification(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    // This is the method that is called in the JsonFileModification class
    public void setJsonObject(String key, JsonObject value) {
        jsonObject.add(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public JsonFileModification getJsonObject(String key, JsonObject defaultValue) {
        if (jsonObject.has(key)) {
            return new JsonFileModification(jsonObject.getAsJsonObject(key));
        } else {
            setJsonObject(key, defaultValue);
            return new JsonFileModification(defaultValue);
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setBooleanValue(String key, boolean value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public boolean getBooleanValue(String key, boolean defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsBoolean();
        } else {
            setBooleanValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setStringValue(String key, String value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public String getStringValue(String key, String defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsString();
        } else {
            setStringValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setIntValue(String key, int value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public int getIntValue(String key, int defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsInt();
        } else {
            setIntValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setDoubleValue(String key, double value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public double getDoubleValue(String key, double defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsDouble();
        } else {
            setDoubleValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setFloatValue(String key, float value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public float getFloatValue(String key, float defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsFloat();
        } else {
            setFloatValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setLongValue(String key, long value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public long getLongValue(String key, long defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsLong();
        } else {
            setLongValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setByteValue(String key, byte value) {
        jsonObject.addProperty(key, value);
    }


    // This is the method that is called in the JsonFileModification class
    public byte getByteValue(String key, byte defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsByte();
        } else {
            setByteValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setShortValue(String key, short value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public short getShortValue(String key, short defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsShort();
        } else {
            setShortValue(key, defaultValue);
            return defaultValue;
        }
    }

    // This is the method that is called in the JsonFileModification class
    public void setCharValue(String key, char value) {
        jsonObject.addProperty(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public char getCharValue(String key, char defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsCharacter();
        } else {
            setCharValue(key, defaultValue);
            return defaultValue;
        }
    }


    // This is the method that is called in the JsonFileModification class
    public void setJsonArrayValue(String key, JsonArray value) {
        jsonObject.add(key, value);
    }

    // This is the method that is called in the JsonFileModification class
    public JsonArray getJsonArrayValue(String key, JsonArray defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.getAsJsonArray(key);
        } else {
            setJsonArrayValue(key, defaultValue);
            return defaultValue;
        }
    }

}
