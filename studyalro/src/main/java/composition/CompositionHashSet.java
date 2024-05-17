package composition;

import java.util.Collection;
import java.util.Set;

public class CompositionHashSet<E> extends  ForwardingSet{
    private int count = 0;

    public CompositionHashSet(Set<E> set) {
        super(set);
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
