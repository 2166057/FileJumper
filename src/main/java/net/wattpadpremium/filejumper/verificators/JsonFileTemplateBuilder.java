package net.wattpadpremium.filejumper.verificators;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import net.wattpadpremium.filejumper.JsonFileJumper;
import net.wattpadpremium.filejumper.runnable.JsonVerificationRunnable;

import java.io.File;

public class JsonFileTemplateBuilder {

    private ObjectMapper objectMapper;

    public JsonFileTemplateBuilder() {
        objectMapper = new ObjectMapper();
    }

    public void createJsonFileJumper(File file, JsonVerificationRunnable runnable) {
        try {
            if (!file.exists()) {
                ObjectNode jsonNode = objectMapper.createObjectNode();
                runnable.editTemplate(new JsonFileJumper(jsonNode));
                ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
                writer.writeValue(file, jsonNode);
            } else {
                ObjectNode jsonNode = objectMapper.readValue(file, ObjectNode.class);
                runnable.editTemplate(new JsonFileJumper(jsonNode));
                ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
                writer.writeValue(file, jsonNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
