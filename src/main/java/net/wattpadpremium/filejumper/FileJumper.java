package net.wattpadpremium.filejumper;

import net.wattpadpremium.filejumper.builders.JsonFileJumper;

import java.io.File;

public class FileJumper {

    public static JsonFileJumper createJsonFileJumper(File file) {
        return new JsonFileJumper(file);
    }

}
