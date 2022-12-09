package src.Days;

import src.Utils.Day;

public class Day3 extends Day {
    static String xlat =  "abcdefghijklmnopqrstuvwxyz"+"abcdefghijklmnopqrstuvwxyz".toUpperCase(); //xd
    public static int occurrences(String pack, char c) {
        int occ=0;
        for (char n : pack.toCharArray()) {
            if (n==c)
                occ++;
        }
        return occ;
    }
    @Override
    public String part1() throws Exception { // haven't tested, should work tho
        int prios = 0;
        int count1, count2, matches;
        String line;
        String pack1, pack2;
        char aux;
        while ((line = input.readLine())!=null) {
            pack1 = line.substring(0,line.length()/2);
            pack2 = line.substring(line.length()/2);

            while (!"".equals(pack1)) {
                aux = pack1.charAt(0);
                count1 = occurrences(pack1, aux);
                count2 = occurrences(pack2, aux);
                matches = Math.min(count1, count2);
                if (matches > 0) matches = 1;
                pack1 = pack1.replaceAll(""+aux, "");
                pack2 = pack2.replaceAll(""+aux, "");
                prios += matches * (xlat.indexOf(aux)+1);
            }
        }

        return String.valueOf(prios);
    }

    @Override
    public String part2() throws Exception {
        throw new Exception("Lost this code, gotta find it sometime");
    }
}
