package src.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EZParser extends BufferedReader {
    public EZParser(int day) throws Exception {
        super(new FileReader("InputFiles"+ File.separator+"Day"+day+".txt"));
    }
}
