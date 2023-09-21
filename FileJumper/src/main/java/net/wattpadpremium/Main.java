package net.wattpadpremium;

import com.google.gson.JsonObject;
import net.wattpadpremium.filejumper.JsonFileJumper;
import net.wattpadpremium.filejumper.runnable.JsonVerificationRunnable;
import net.wattpadpremium.filejumper.verificators.JsonFileTemplateBuilder;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JsonFileJumper fileJumper = JsonFileTemplateBuilder.createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
            @Override
            protected void editTemplate(JsonFileJumper jumper) {
                check("BooleanTemplateExample",true);
                check("StringTemplateExample","String");
                check("IntegerTemplateExample",123);
                check("DoubleTemplateExample",256.33);
                checkNestedDoubleValue("Nested.Double", 34234.33);
                try {
                    jumper.getFileWriter().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    jumper.getFileReader().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("propertyNumber", 1234);
                jsonObject.addProperty("propertyString", "CustomObjectString");
                jumper.writeJsonObjectToFile("CustomObject",jsonObject);
            }
        });
    }

}