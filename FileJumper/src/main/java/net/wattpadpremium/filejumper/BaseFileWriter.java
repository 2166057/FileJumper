package net.wattpadpremium.filejumper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BaseFileWriter extends FileWriter implements FileClosable {
    private Boolean closed = false;
    public BaseFileWriter(File file) throws IOException {
        super(file);
    }

    @Override
    public void close(){
        this.closed = true;
        try {
            super.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Boolean IsClosed() {
        return closed;
    }
}
