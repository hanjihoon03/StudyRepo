package composition;

import java.util.Collection;
import java.util.HashSet;

public class CustomHashSet<E> extends HashSet {

    private int count = 0;

    public CustomHashSet(){}

    public CustomHashSet(int initCap, float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }

}
