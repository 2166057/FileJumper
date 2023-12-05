package net.wattpadpremium.filejumper.abstraction;

import net.wattpadpremium.filejumper.JsonFileModification;

public abstract class JsonTask {

    // This is the method that is called in the JsonFileCreator class
    public abstract void editTemplate(JsonFileModification jumper);

}
