package src.Days;

import src.Utils.Day;

import java.util.ArrayList;

public class Day7 extends Day {
    Dir root;
    Dir wd;
    public void init(int d) {
        super.init(d);
        root = new Dir(null, "root");
        root.parent = root;
        wd=root;
    }

    public void cd(String path) {
        if (path.startsWith("/")) {
            // Absolute path
            if ("/".equals(path)) {
                wd = root;
            }
        } else {
            // Relative path
            if ("..".equals(path))
                wd = wd.parent;
            for (Item i : wd.children) {
                if (i.isDirectory()) {
                    if (i.name.equals(path)) {
                        wd= (Dir) i;
                    }
                }
            }
        }
    }
    public ArrayList<? extends Item> ls() {
        return wd.children;
    }

    public String part1() throws Exception {
        throw new Exception("Do later");
    }

    public String part2() throws Exception {
        throw new Exception("Ask da homie");
    }
}


abstract class Item {
    Dir parent;
    String name;

    public Item(Dir p, String n) {
        parent = p;
        name = n;
    }

    public abstract int size();
    public abstract boolean isDirectory();
}
class Dir extends Item {
    ArrayList<? extends Item> children;

    public Dir(Dir p, String n) {
        super(p, n);
        children = new ArrayList<>();
    }
    public boolean isDirectory() {
        return true;
    }
    public int size() {
        int s = 0;
        for (Item i : children) {
            s += i.size();
        }
        return s;
    }
}
class File extends Item {
    int size;
    public File(Dir p, String n, int s) {
        super(p, n);
        size=s;
    }

    public int size() {
        return size;
    }
    public boolean isDirectory() {
        return false;
    }
}
