import java.util.*;

public class SortMountains {
    LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>{
        public int compare(Mountain one, Mountain two) {
            return one.name.compareTo(two.name);
        }

    }

    class HeightCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return (two.height - one.height);
        }
    }

    public static void main(String[] args){
        new SortMountains().go();
    }

    public void go() {
        mtn.add(new Mountain("longs", 14255));
        mtn.add(new Mountain("elbert", 14455));
        mtn.add(new Mountain("marron", 14155));
        mtn.add(new Mountain("castle", 14265));
        System.out.println("as entered:\n" + mtn);
        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc);
        System.out.println("by name:\n" + mtn);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("by height:\n" + mtn);
    }
}

    class Mountain {
        int height;
        String name;

        Mountain(String n, int h){
            height = h;
            name = n;
        }

        public String toString() {
            return name + " " + height;
        }
        }

    
    

