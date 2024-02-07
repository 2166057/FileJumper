package net.wattpadpremium.filejumper.filemodificator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonFileModificator {
    private final JsonObject jsonObject;
    private final boolean saveDefaultValue;

    public JsonFileModificator(JsonObject jsonObject) {
        this(jsonObject, false);
    }
    public JsonFileModificator(JsonObject jsonObject, boolean saveDefaultValue) {
        this.jsonObject = jsonObject;
        this.saveDefaultValue = saveDefaultValue;
    }

    public void setJsonObject(String key, JsonObject value) {
        jsonObject.add(key, value);
    }

    public JsonFileModificator getJsonObject(String key, JsonObject defaultValue) {
        if (jsonObject.has(key)) {
            return new JsonFileModificator(jsonObject.getAsJsonObject(key), saveDefaultValue);
        } else {
            if (saveDefaultValue){
                setJsonObject(key, defaultValue);
            }
            return new JsonFileModificator(defaultValue, saveDefaultValue);
        }
    }

    public void setBooleanValue(String key, boolean value) {
        jsonObject.addProperty(key, value);
    }

    public boolean getBooleanValue(String key, boolean defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.get(key).getAsBoolean();
        } else {
            if (saveDefaultValue){
                setBooleanValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setStringValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setIntValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setDoubleValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setFloatValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setLongValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setByteValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setShortValue(key, defaultValue);
            }
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
            if (saveDefaultValue){
                setCharValue(key, defaultValue);
            }
            return defaultValue;
        }
    }


    public void setJsonArrayValue(String key, JsonArray value) {
        jsonObject.add(key, value);
    }

    public JsonArray getJsonArrayValue(String key, JsonArray defaultValue) {
        if (jsonObject.has(key)) {
            return jsonObject.getAsJsonArray(key);
        } else {
            if (saveDefaultValue){
                setJsonArrayValue(key, defaultValue);
            }
            return defaultValue;
        }
    }

}
