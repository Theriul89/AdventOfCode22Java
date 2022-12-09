package src.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Matrix {
    private final List<List<Integer>> data;
    public final int rows, cols;
    public static Matrix parse(EZParser input) throws IOException {
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
    public Matrix(List<List<Integer>> xd) {
        data=xd;
        rows = xd.size();
        cols = xd.get(0).size();
    }
    public int get(int x, int y) { return data.get(x).get(y); }

    public ArrayList<Integer> col(int x) {
        var result = new ArrayList<Integer>();
        for (int i=0; i<rows; i++) {
            result.add(get(x,i));
        }
        return result;
    }
    public ArrayList<Integer> row(int y) {
        var result = new ArrayList<Integer>();
        for (int i=0; i<cols; i++) {
            result.add(get(i,y));
        }
        return result;
    }

    public int max(List<Integer> si) {
        int max=0;
        for (int x : si) {
            if (x>max)
                max=x;
        }
        return max;
    }
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

    private void getSides(int x, int y, List<Integer> up, List<Integer> down,List<Integer> left,List<Integer> right) {
        var r = row(y);
        var c = col(x);
        up.addAll(c.subList(0, y));
        down.addAll(c.subList(y+1, c.size()));
        left.addAll(r.subList(0,x));
        right.addAll(r.subList(x+1,c.size()));
    }

    public int scenicScore(int x, int y) {
        var n = get(x,y);
        List<Integer>
                up =new ArrayList<>(),
                down=new ArrayList<>(),
                left=new ArrayList<>(),
                right=new ArrayList<>();
        getSides(x, y, up, down, left, right);
        return 0; // do later
    }

    public void forEach(Consumer<Integer> xd) {
        data.forEach(l -> l.forEach(xd));
    }
}
