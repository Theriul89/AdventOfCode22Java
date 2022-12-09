package src.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Matrix {
    private final List<List<Integer>> data;
    public final int rows, cols;

    // Should be placing a bufferedReader here, imma do that tho
    public static Matrix parse(BufferedReader input) throws IOException {
        String line;
        var xd = new ArrayList<List<Integer>>();
        while ((line = input.readLine())!=null) {
            var aux = new ArrayList<Integer>();
            for (char n : line.toCharArray()) {
                aux.add(Integer.parseInt(String.valueOf(n)));
            }
            xd.add(aux);
        }
        return new Matrix(xd);
    }

    // Empty matrix
    public Matrix(int x, int y) {
        data = new ArrayList<>();
        for (int i=0;i<x;i++) {
            ArrayList<Integer> aux = new ArrayList<>();
            for (int j=0;j<y;j++)
                aux.add(0);
            data.add(aux);
        }
        rows = x;
        cols = y;
    }

    // Helper constructor for parsing
    public Matrix(List<List<Integer>> xd) {
        data=xd;
        rows = xd.size();
        cols = xd.get(0).size();
    }

    // Get element at (x,y)
    public int get(int x, int y) { return data.get(x).get(y); }

    // Column "x"
    public ArrayList<Integer> col(int x) {
        var result = new ArrayList<Integer>();
        for (int i=0; i<rows; i++) {
            result.add(get(x,i));
        }
        return result;
    }

    // Row "y"
    public ArrayList<Integer> row(int y) {
        var result = new ArrayList<Integer>();
        for (int i=0; i<cols; i++) {
            result.add(get(i,y));
        }
        return result;
    }

    // returns the highest integer in a given list (for column and row use)
    public int max(List<Integer> si) {
        int max=0;
        for (int x : si) {
            if (x>max)
                max=x;
        }
        return max;
    }

    // Gets row and column elements without including the int at (x,y)
    // Ordered upside-down and left-right
    /*
    *                      UP[0]
    *                        ·
    *                        ·
    *                      UP[n]
    * LEFT[0] ·· LEFT[N]   (x,y)   RIGHT[0] ·· RIGHT[n]
    *                     DOWN[0]
    *                        ·
    *                        ·
    *                     DOWN[n]
    *///Chart
    private void getSides(int x, int y, List<Integer> up, List<Integer> down,List<Integer> left,List<Integer> right) {
        var r = row(y);
        var c = col(x);
        up.addAll(c.subList(0, y));
        down.addAll(c.subList(y+1, c.size()));
        left.addAll(r.subList(0,x));
        right.addAll(r.subList(x+1,c.size()));
    }

    // Iterate all elements
    public void forEach(Consumer<Integer> xd) {
        data.forEach(l -> l.forEach(xd));
    }
    //todo Iterator by position
    public void forEachPos(BiConsumer<Integer, Integer> pos) {
        for (int x=0; x<cols;x++) {
            for (int y=0; y<rows;y++) {
                pos.accept(x,y);
            }
        }
    }


    // Day8 funcs

    // 8-1

    // Check if tree is visible from outside
    public boolean xVisible(int x, int y) {
        if (x==0 || x==cols-1)
            return true;
        if (y==0 || y==rows-1)
            return true;

        int n = get(x,y);
        List<Integer>
                up =new ArrayList<>(),
                down=new ArrayList<>(),
                left=new ArrayList<>(),
                right=new ArrayList<>();
        getSides(x, y, up, down, left, right);

        return max(up)<n || max(down)<n || max(left) <n || max(right)<n;
    }

    // 8-2

    // Optimal render distance to reach an equal or higher tree :)
    //todo CHECK IF PROBLEMATIC CODE SHIT
    public int renderDistance(List<Integer> side, int n, boolean reverse) {
        int distance = 1;
        if (reverse) {
            for (int i=side.size()-1;i>=0;i--) { // Cannot be replaced: forEach
                if (side.get(i)>=n) {
                    return distance;
                } else {
                    distance++;
                }
            }
        } else {
            for (int i=0;i<side.size();i++) { // Can be replaced: forEach
                if (side.get(i)>=n) {
                    return distance;
                } else {
                    distance++;
                }
            }
        }
        return distance; // At least 1 even if you are outside (0 trees to view should not become 0 scenic score)
    }

    // Get scenicScore from tree
    //todo NEEDS URGENT FIX
    public int scenicScore(int x, int y) {
        var n = get(x,y);
        List<Integer>
                up =new ArrayList<>(),
                down=new ArrayList<>(),
                left=new ArrayList<>(),
                right=new ArrayList<>();
        getSides(x, y, up, down, left, right);
        int
                a= renderDistance(up,n,true),
                b= renderDistance(down,n,false),
                c= renderDistance(left,n,true),
                d= renderDistance(right,n,false);
        return a*b*c*d; // Get score from all sides
    }
}
