package src.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EZParser extends BufferedReader {
    public static EZParser get(int day) {
        try {
            return new EZParser(day);
        } catch (Exception e) {
            System.out.println("Your file is not ok");
            throw new RuntimeException(e);
        }
    }
    public EZParser(int day) throws Exception {
        super(new FileReader("InputFiles"+ File.separator+"Day"+day+".txt"));
    }
}
