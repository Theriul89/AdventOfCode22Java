package src.Utils;

import java.io.IOException;

public abstract class Day {
    public int day;
    public static EZParser input;
    public void init(int d) {
        try {
            input = new EZParser(d);
            day = d;
        } catch (Exception e) {
            throw new RuntimeException("\r\nYour file is trash\r\nIt should be like: \"InputFiles/Day"+d+".txt\"");
            //                           ^^^ read further      ^^^ this indicates ur file is trash rn
        }
    }
    public void close() {
        if (input!=null) {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("This program is retarded and can't read");
                throw new RuntimeException(e);
            }
        }
    }

    public String part1() throws Exception { return ""; }
    public String part2() throws Exception { return ""; }
}
