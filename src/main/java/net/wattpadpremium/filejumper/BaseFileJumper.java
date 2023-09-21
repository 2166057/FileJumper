package net.wattpadpremium.filejumper;

import java.io.*;

public class BaseFileJumper {
    private BaseFileReader fileReader;
    private BaseFileWriter fileWriter;
    private final File file;
    public BaseFileJumper(File file) {
        this.file = file;
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Unable to create file!!");
            }
        }
        try {
            fileReader = new BaseFileReader(file);
            fileWriter = new BaseFileWriter(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public File getFile() {
        return file;
    }

    public FileReader getFileReader(){
        if (fileReader.IsClosed()){
            try {
                fileReader = new BaseFileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return fileReader;
    }
    public FileWriter getFileWriter(){
        if (fileWriter.IsClosed()){
            try {
                fileWriter = new BaseFileWriter(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileWriter;
    }




}
