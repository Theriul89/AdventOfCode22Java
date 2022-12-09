package src.Days;

import src.Utils.Day;
import src.Utils.Matrix;

import java.util.concurrent.atomic.AtomicInteger;

public class Day8 extends Day {
    public void part1() throws Exception {
        Matrix xd = Matrix.parse(input);
        int i=0;
        for (int x=0; x<xd.cols;x++) {
            for (int y=0; y<xd.rows;y++) {
                if (xd.xVisible(x,y))
                    i+=1;
            }
        }
        System.out.println(i);
    }

    public void part2() throws Exception {
        Matrix xd = Matrix.parse(input);

    }
}
