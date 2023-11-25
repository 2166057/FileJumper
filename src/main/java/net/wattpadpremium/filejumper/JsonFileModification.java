package net.wattpadpremium.filejumper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonFileModification {
    private final JsonObject jsonObject;
    public JsonFileModification(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }
    public void setJsonObject(String key, JsonObject value) {
        jsonObject.add(key, value);
    }
    public JsonFileModification getJsonObject(String key, JsonObject defaultValue) {
        if (jsonObject.has(key)) {
            return new JsonFileModification(jsonObject.getAsJsonObject(key));
        } else {
            setJsonObject(key, defaultValue);
            return new JsonFileModification(defaultValue);
        }
    }
    public void setBooleanValue(String key, boolean value) {
        jsonObject.addProperty(key, value);
    }
    public boolean getBooleanValue(String key, boolean defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsBoolean();
        } else {
            setBooleanValue(key, defaultValue);
            return defaultValue;
        }
    }

    public void setStringValue(String key, String value) {
        jsonObject.addProperty(key, value);
    }
    public String getStringValue(String key, String defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsString();
        } else {
            setStringValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setIntValue(String key, int value) {
        jsonObject.addProperty(key, value);
    }
    public int getIntValue(String key, int defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsInt();
        } else {
            setIntValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setDoubleValue(String key, double value) {
        jsonObject.addProperty(key, value);
    }
    public double getDoubleValue(String key, double defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsDouble();
        } else {
            setDoubleValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setFloatValue(String key, float value) {
        jsonObject.addProperty(key, value);
    }
    public float getFloatValue(String key, float defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsFloat();
        } else {
            setFloatValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setLongValue(String key, long value) {
        jsonObject.addProperty(key, value);
    }
    public long getLongValue(String key, long defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsLong();
        } else {
            setLongValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setByteValue(String key, byte value) {
        jsonObject.addProperty(key, value);
    }
    public byte getByteValue(String key, byte defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsByte();
        } else {
            setByteValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setShortValue(String key, short value) {
        jsonObject.addProperty(key, value);
    }
    public short getShortValue(String key, short defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsShort();
        } else {
            setShortValue(key, defaultValue);
            return defaultValue;
        }
    }
    public void setCharValue(String key, char value) {
        jsonObject.addProperty(key, value);
    }
    public char getCharValue(String key, char defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsCharacter();
        } else {
            setCharValue(key, defaultValue);
            return defaultValue;
        }
    }

}
