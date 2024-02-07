package net.wattpadpremium.filejumper.utilities;

import java.io.File;
import java.io.IOException;

public class FilePathCreationTool {
    public static void createMissingFileAndFolders(File file) {
        if (!file.exists()) {
            File parentFolder = file.getParentFile();

            if (parentFolder != null && !parentFolder.exists()) {
                if (!parentFolder.mkdirs()) {
                    throw new RuntimeException("Failed to create parent folders: " + parentFolder.getAbsolutePath());
                }
            }

            try {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Failed to create file: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error while creating file: " + file.getAbsolutePath(), e);
            }
        }
    }

}
