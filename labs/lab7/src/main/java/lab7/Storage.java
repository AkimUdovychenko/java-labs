package lab7;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Storage<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) { items.add(item); }

    public List<T> getAll() { return List.copyOf(items); }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public Optional<T> find(Predicate<T> predicate) {
        return items.stream().filter(predicate).findFirst();
    }

    public List<T> sort(Comparator<T> comparator) {
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    public boolean remove(Predicate<T> predicate) {
        Optional<T> toRemove = find(predicate);
        toRemove.ifPresent(items::remove);
        return toRemove.isPresent();
    }
}
