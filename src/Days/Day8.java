package src.Days;

import src.Utils.Day;
import src.Utils.Matrix;

import java.util.concurrent.atomic.AtomicInteger;

public class Day8 extends Day {
    public String part1() throws Exception {
        Matrix xd = Matrix.parse(input);
        AtomicInteger i= new AtomicInteger();
        xd.forEachPos(
                (x,y) -> i.addAndGet(xd.xVisible(x,y)? 1:0) // For each pair (x,y)
        );
        return String.valueOf(i.get());
    }

    public String part2() throws Exception {
        Matrix xd = Matrix.parse(input);
        AtomicInteger maxScore= new AtomicInteger();
        AtomicInteger score = new AtomicInteger();
        xd.forEachPos((x,y) -> {
            score.set(xd.scenicScore(x, y));
            if (score.get() > maxScore.get()) {
                maxScore.set(score.get());
            }
        });
        return String.valueOf(maxScore.get()) + "Not ok at all wtf is this number bro";
    }
}
