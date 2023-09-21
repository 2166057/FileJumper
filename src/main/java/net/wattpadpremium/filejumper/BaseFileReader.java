package net.wattpadpremium.filejumper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BaseFileReader extends FileReader implements FileClosable{
    private Boolean closed = false;
    public BaseFileReader(File file) throws FileNotFoundException {
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
