package Algoritmi_HW;

public interface Dynamic {
    void add(int data);

    void addAt(int index, int data);

    void remove(int data);

    void removeAt(int index);

    void growSize();

    void shrinkSize();

    void set(int Index, int data);

    int get(int index);

    void clear();

    boolean contains(int data);

    boolean isEmpty();
}