package Algoritmi_HW;

public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.add(5);
        dynamicArray.add(2);
        dynamicArray.add(1);
        System.out.println(dynamicArray);
        dynamicArray.set(1,8);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.contains(8));
        System.out.println(dynamicArray.isEmpty());
        dynamicArray.addAt(1,9);
        System.out.println(dynamicArray);
        dynamicArray.removeAt(1);
        System.out.println(dynamicArray);
//        System.out.println(dynamicArray.get(1));
//        dynamicArray.growSize();
//        System.out.println(dynamicArray);
//        dynamicArray.shrinkSize();
//        System.out.println(dynamicArray);
//        dynamicArray.clear();
//        System.out.println(dynamicArray);
    }
}
