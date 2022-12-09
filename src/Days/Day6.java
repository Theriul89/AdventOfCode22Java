package src.Days;

import src.Utils.Day;

import java.util.ArrayList;

public class Day6 extends Day {
    public boolean isPacketMarker(String xd) {
        if (xd.charAt(0)==xd.charAt(1) ||xd.charAt(0) == xd.charAt(2) ||xd.charAt(0)==xd.charAt(3))
            return false;
        else if (xd.charAt(1)==xd.charAt(2) || xd.charAt(1)==xd.charAt(3))
            return false;
        else return xd.charAt(2) != xd.charAt(3); // should be: if (xd.charAt(2)==xd.charAt(3)) return false; else return true;
    }
    public String part1() throws Exception {
        String xd = input.readLine();
        int s1 = xd.length();
        while (!xd.isEmpty() && !isPacketMarker(xd))
                xd = xd.substring(1);
        return String.valueOf(s1-xd.length()+4);
    }

    public boolean isMessageMarker(String xd) {
        ArrayList<Character> aux = new ArrayList<>();
        for (int i=0; i<14; i++) {
            if (aux.contains(xd.charAt(i)))
                return false;
            aux.add(xd.charAt(i));
        }
        return true;
    }

    public String part2() throws Exception {
        String xd = input.readLine();
        int s1 = xd.length();
        while (!xd.isEmpty() && !isMessageMarker(xd)) {
            xd=xd.substring(1);
        }
        return String.valueOf(s1-xd.length()+14);
    }
}
