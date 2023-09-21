package net.wattpadpremium.filejumper.verificators;


import net.wattpadpremium.filejumper.JsonFileJumper;
import net.wattpadpremium.filejumper.runnable.JsonVerificationRunnable;

import java.io.File;

public abstract class JsonFileTemplateBuilder {
    private JsonFileTemplateBuilder(){}
    public static JsonFileJumper createJsonFileJumper(File file, JsonVerificationRunnable verification) {
        return new JsonFileJumper(file,verification);
    }



}
