package composition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompositionHashSet<String> customHashSet = new CompositionHashSet<>(new HashSet<>());
        List<String> test = Arrays.asList("a","b","c");
        customHashSet.addAll(test);

        System.out.println(customHashSet.getCount()); // 3
    }
}