package uaslp.enginering.labs.list.model;

import uaslp.enginering.labs.list.Student;

public abstract class Lists {

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public abstract int size();

    public abstract void add(Student element);

    public abstract void delete(int index);

    public  abstract void insert(Student reference,Student newStudent, InsertPosition InsertPosition);


}
