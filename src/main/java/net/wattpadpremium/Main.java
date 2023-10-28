package net.wattpadpremium;

import net.wattpadpremium.filejumper.JsonFileJumper;
import net.wattpadpremium.filejumper.runnable.JsonVerificationRunnable;
import net.wattpadpremium.filejumper.verificators.JsonFileTemplateBuilder;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        new JsonFileTemplateBuilder().createJsonFileJumper(new File("File.json"), new JsonVerificationRunnable() {
            @Override
            public void editTemplate(JsonFileJumper jumper) {
                jumper.checkNestedBooleanValue("BooleanTemplateExample",true);
                jumper.checkNestedStringValue("StringTemplateExample","String");
                jumper.checkNestedDoubleValue("DoubleTemplateExample",454.0);
                jumper.setNestedIntegerValue("SetInteger",4);
            }
        });
    }

}