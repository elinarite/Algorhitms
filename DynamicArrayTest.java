package Algoritmi_HW;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @org.junit.jupiter.api.Test
    void add() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.add(15);
        assertEquals(5, dynamicArray.get(0));
        assertEquals(10, dynamicArray.get(1));
        assertEquals(15, dynamicArray.get(2));
    }

    @org.junit.jupiter.api.Test
    void addAt() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addAt(1,5);
        assertEquals(5,dynamicArray.get(1));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.add(15);
        dynamicArray.remove(10);
        assertEquals(5, dynamicArray.get(0));
        assertEquals(15, dynamicArray.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeAt() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.add(15);
        dynamicArray.removeAt(1);
        assertEquals(5, dynamicArray.get(0));
        assertEquals(15, dynamicArray.get(1));
    }

    @org.junit.jupiter.api.Test
    void growSize() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.growSize();
        assertEquals(20, dynamicArray.size);
    }

    @org.junit.jupiter.api.Test
    void shrinkSize() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.add(15);
        dynamicArray.shrinkSize();
        assertEquals(5, dynamicArray.get(0));
        assertEquals(10, dynamicArray.get(1));
        assertEquals(15, dynamicArray.get(2));
        assertEquals(3, dynamicArray.size);
    }


    @org.junit.jupiter.api.Test
    void set() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.set(0,5);
        assertEquals(5, dynamicArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void get() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        assertEquals(5, dynamicArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.add(5);
        dynamicArray.add(10);
        dynamicArray.clear();
        assertEquals(0, dynamicArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.add(5);
        dynamicArray.add(10);
        assertFalse(dynamicArray.contains(9));
        assertTrue(dynamicArray.contains(5));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.add(5);
        dynamicArray.add(10);
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.clear();
        assertTrue(dynamicArray.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}