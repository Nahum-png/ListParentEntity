package uaslp.enginering.labs.list.model;

public abstract class Lists<T> {
    private int size;
    private int index;

    public enum InsertPosition{
        BEFORE,
        AFTER
    }

    public abstract int size();

    public abstract void add(T element);

    public abstract void delete(int index);

    public abstract void insert(T reference, T newElement, InsertPosition position);
}
