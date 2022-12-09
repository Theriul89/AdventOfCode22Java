package src;

import src.Days.Day7;
import src.Days.Day8;
import src.Utils.Day;
import src.Days.Day6;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manin {
    static Scanner xd = new Scanner(System.in);
    final static int daysDone = 7;

    private static int optParser(int n) {
        int opt;
        do {
            try {
                opt = Integer.parseInt(xd.nextLine());
            } catch (Exception e) {
                opt = 0;
            }
        } while (opt<1 || opt > n);
        return opt;
    }
    private static ArrayList<Day> forgetThisFunction() {
        var yes = new ArrayList<Day>();
        File daysDir = new File("InputFiles");
        {
            if (!daysDir.isDirectory())
                throw new RuntimeException("Directory does not exist or is a file");
            if (daysDir.listFiles() == null || Objects.requireNonNull(daysDir.listFiles()).length==0)
                throw new RuntimeException("Dir has no files kekw");
        } // Dir checks

        // Change this crap for some reflection magic sticks
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 0
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 1 add later
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 2 add later
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 3 add later
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 4 add later
        yes.add(new Day(){
            public void part1() {}
            public void part2() {}
        }); // Do nothing 5 add later
        yes.add(new Day6());
        yes.add(new Day7());
        yes.add(new Day8());

        return yes;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Day> finisimo = forgetThisFunction();
        int day, part;
        do {
            System.out.print("Choose day (1-"+(daysDone+1)+"): ");
            day = optParser(daysDone+1);
        } while (day==0);
        do {
            System.out.print("Part (1-2): ");
            part = optParser(2);
        } while (part==0);

        Day d = finisimo.get(day);
        d.init(day);
        System.out.println("Day "+ day);
        System.out.println("Part "+ part);
        if (part==1) {
            d.part1();
        } else {
            d.part2();
        }
        d.close();
    }
}
