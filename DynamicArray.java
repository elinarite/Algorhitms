package Algoritmi_HW;

import java.util.Arrays;

public class DynamicArray implements Dynamic {
    int[] array = new int[10];
    int count;
    int size;

    public DynamicArray() {
    }

    public DynamicArray(int size) {
        this.size = size;
        array = new int[size];
        count = 0;
    }

    /**
     * add(int data); void -  добавляет элемент в конец
     */
    @Override
    public void add(int data) {
        if (count == size) {
            growSize();
        }
        array[count] = data;
        count++;
    }

    /**
     * -addAt(int data); void - добавляет элемент по индексу, при этом,
     * если это происходит в середине,
     * то все остальные элементы сдвигаются на 1 вправо
     */

    //
    @Override
    public void addAt(int index, int data) {
        if (count == size) {
            growSize();
        }
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        count++;
    }

    /**
     * -remove(int data); void - удаляет первое вхождение элемента в массив,
     * все остальные элементы справа,
     * сдвигаются на 1 влево
     */

    @Override
    public void remove(int data) {
        int a = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == data) {
                array[i] = array[i + 1];
                a = i;
            } else if (a < i) {
                array[i] = array[i + 1];
            }
        }
        count--;
    }

    /**
     * -removeAt(int index); void - удаляет элемент по индексу, все остальные
     * элементы справа, сдвигаются на 1 влево
     */
    @Override
    public void removeAt(int index) {
        int a = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (i == index) {
                array[i] = array[i + 1];
                a = i;
            } else if (a < i) {
                array[i] = array[i + 1];
            }
        }
        count--;
    }

    /**
     * growSize(); void - удваивает размер массива (capacity)
     */
    @Override
    public void growSize() {
        array = Arrays.copyOf(array, array.length * 2);
        size = size * 2;
    }

    /**
     * -shrinkSize(); void - уменьшает размер массива до количества
     * элементов (capacity = size)
     */

    @Override
    public void shrinkSize() {
        size = count;
        array = Arrays.copyOf(array, size);
    }

    /**
     * -set(int index, int data); void - заменяет значения элемента по указанному индексу
     */

    @Override
    public void set(int index, int data) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                array[i] = data;
            }
        }
    }

    /**
     * -get(int index); int - возвращает элемент по указанному индексу
     * (должна быть обработка, если capacity позволяет добраться до этого
     * элемента, а size - нет)
     */

    @Override
    public int get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        return 0;
    }

    /**
     * -clear(); void - удаляет все элементы из массива возвращая массив
     * исходной длины (длина по умолчанию)
     */
    @Override
    public void clear() {
        count = 0;
        array = Arrays.copyOf(array, 10);
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    /**
     * -contains(int data); boolean - возвращает true/false - если элемент есть в массиве
     */
    @Override
    public boolean contains(int data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }

    /**
     * -isEmpty(); boolean - возвращает true/false - если в массиве есть что-то.
     */

    @Override
    public boolean isEmpty() {
        if (count > 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                ", size=" + size +
                '}';
    }
}