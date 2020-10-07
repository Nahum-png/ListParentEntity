package uaslp.enginering.labs.list;

import uaslp.enginering.labs.list.model.Lists;

public class ArrayList extends Lists {

    public enum InsertPosition {
        BEFORE,
        AFTER
    }


    public class Iterator  {

        private int currentIndex;

        public boolean hasNext() {
            return currentIndex < lastIndex;
        }

        public Student next() {
            return (Student) elements[currentIndex++];
        }

    }


    public static final int DEFAULT_SIZE = 2;

    private Student[] elements;
    private int lastIndex;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialSize) {
        lastIndex = 0;
        elements = new Student[initialSize];
    }

    @Override
    public void delete(int index) {
        if (lastIndex - index > 0 && index >= 0) {
            lastIndex--;
            System.arraycopy(elements, index + 1, elements, index, lastIndex - index);
        }
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return lastIndex;
    }

    @Override
    public void add(Student element) {
        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        elements[lastIndex++] = element;
    }

    public Student getAt(int index) {
        return index < lastIndex ? (Student)elements[index] : null;
    }

    @Override
    public void insert(Student reference,Student newStudent, Lists.InsertPosition InsertPosition) {

        if (lastIndex == elements.length) {
            increaseArraySize();
        }

        for (int index = 0; index < lastIndex; index++) {
            if (elements[index].equals(reference)) {
                if (InsertPosition.equals(InsertPosition.BEFORE)) {
                    for (int j = lastIndex; j > index; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index] = newStudent;
                } else {
                    for (int j = lastIndex; j > index + 1; j--) {
                        elements[j] = elements[j - 1];
                    }
                    elements[index + 1] = newStudent;
                }
                break;
            }
        }
        lastIndex++;
    }

    private void increaseArraySize() {
        Student[] newArray = new Student[elements.length * 2];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        elements = newArray;
    }
}
