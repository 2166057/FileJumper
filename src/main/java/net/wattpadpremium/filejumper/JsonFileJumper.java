package net.wattpadpremium.filejumper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonFileJumper {
    private ObjectNode jsonNode;

    public JsonFileJumper(ObjectNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public void setNestedBooleanValue(String key, boolean value) {
        jsonNode.put(key, value);
    }

    public boolean checkNestedBooleanValue(String key, boolean defaultValue) {
        JsonNode node = jsonNode.get(key);
        if (node != null && node.isBoolean()) {
            return node.asBoolean();
        } else {
            setNestedBooleanValue(key, defaultValue);
            return defaultValue;
        }
    }

    public void setNestedIntegerValue(String key, int value) {
        jsonNode.put(key, value);
    }

    public int checkNestedIntegerValue(String key, int defaultValue) {
        JsonNode node = jsonNode.get(key);
        if (node != null && node.isInt()) {
            return node.asInt();
        } else {
            setNestedIntegerValue(key, defaultValue);
            return defaultValue;
        }
    }

    public void setNestedDoubleValue(String key, double value) {
        jsonNode.put(key, value);
    }

    public double checkNestedDoubleValue(String key, double defaultValue) {
        JsonNode node = jsonNode.get(key);
        if (node != null && node.isDouble()) {
            return node.asDouble();
        } else {
            setNestedDoubleValue(key, defaultValue);
            return defaultValue;
        }
    }

    public void setNestedStringValue(String key, String value) {
        jsonNode.put(key, value);
    }

    public String checkNestedStringValue(String key, String defaultValue) {
        JsonNode node = jsonNode.get(key);
        if (node != null && node.isTextual()) {
            return node.asText();
        } else {
            setNestedStringValue(key, defaultValue);
            return defaultValue;
        }
    }
}
