package Algoritmi_HW.HanoiTown;

import java.util.*;

public class HanoiTownSergei {

    /**
     * HanoyTower.java
     *
     * @author Sergii Kozhushko, sergiikozhushko@gmail.com
     * Date of creation: 18-Mar-2023 18:48
     */
    public static void main(String[] args) {
        for (int i = N; i > 0; i--) {
            stack1.push(i);
        }

        Queue<String> queue = new PriorityQueue<>(List.of("B", "A", "C", "B", "A", "C"));
        System.out.println(queue);
        print();
        hanoiIterative(0, 0); // итеративно-рекурсивное решение

       // hanoiRecursive(N, 1, 2, 3); // классическое рекурсивное решение
    }


    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();
    private static final Stack<Integer> stack3 = new Stack<>();

    // число блоков
    private static final int N = 5; // у меня на 12-м итеративном переполяется стек :)
    // рекурсивный 17 отрабатывает, но делает минут 5, дальше пробовтаь не хочется

    // число итераций
    private static int count = 0;

    private static void moveRing(int sourceTower, int destTower) {
        // делаем текущий ход
        Integer sourceRing; // какой блок переместить

        sourceRing = switch (sourceTower) {
            case (1) -> stack1.pop();
            case (2) -> stack2.pop();
            case (3) -> stack3.pop();
            default -> 0;
        };
        switch (destTower) {
            case (1) -> stack1.push(sourceRing);
            case (2) -> stack2.push(sourceRing);
            case (3) -> stack3.push(sourceRing);
        }
        // перемещаем блок на новое место
        print();
    }

   private static void hanoiRecursive(int n, int source, int auxiliary, int destination) {
        if (n == 1) {
            //System.out.println("1 ring goes " + source + "->" + destination);
            moveRing(source, destination);
            return;
        }
        //
        // перемещаем n-1  колец на вспомогательную башню
        hanoiRecursive(n - 1, source, destination, auxiliary);

        // перемещаем кольцо n с первой башни на целевую
        moveRing(source, destination);
        //System.out.println(n + " ring goes " + source + "->" + destination);

        // перемещаем n-1  колец обратно с вспомогательной башни на целевую на кольцо n
        hanoiRecursive(n - 1, auxiliary, source, destination);
    }


    private static void print() {
        System.out.println(count + " -----");
        count++;
        Integer[] array1 = stack1.toArray(new Integer[stack1.size()]);
        Integer[] array2 = stack2.toArray(new Integer[stack2.size()]);
        Integer[] array3 = stack3.toArray(new Integer[stack3.size()]);

        for (int i = N - 1; i >= 0; i--) {
            if (i < array1.length) {
                System.out.printf("%4d", array1[i]);
            } else {
                System.out.printf("%4s", ".");
            }
            if (i < array2.length) {
                System.out.printf("%4d", array2[i]);
            } else {
                System.out.printf("%4s", ".");
            }
            if (i < array3.length) {
                System.out.printf("%4d", array3[i]);
            } else {
                System.out.printf("%4s", ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    // метод возвращает верхнее кольцо башни
    private static int getRing(int tower) {
        return switch (tower) {
            case (1) -> stack1.size() > 0 ? stack1.peek() : 0;
            case (2) -> stack2.size() > 0 ? stack2.peek() : 0;
            case (3) -> stack3.size() > 0 ? stack3.peek() : 0;
            default -> 0;
        };
    }

    // блок принятия решений
    public static int[] chooseMove(ArrayList<int[]> possibleMoves, int currentSourceTower, int currentDestTower) {
        int resultSourceTower = 0, resultDestTower = 0;
        int resultSourceRing = 0, resultDestRing = 0;

        for (int i = 0; i < possibleMoves.size(); i++) {
            // ход-кандидат
            int possibleSourceTower = possibleMoves.get(i)[0];
            int possibleDestTower = possibleMoves.get(i)[1];
            int possibleSourceRing = getRing(possibleSourceTower);
            int possibleDestRing = getRing(possibleDestTower);

            // если мы пытаемся повторить предыдущий ход, то идем дальше -> выбрать другой
            if (possibleSourceTower == currentDestTower) {
                continue;
            }

            // нечетный диск нельзя размешать не четном
            if (possibleSourceRing % 2 == 1 && possibleDestRing % 2 == 1) {
                continue;
            }
            // четный нельзя размешать на четном
            if (possibleSourceRing % 2 == 0 && resultDestRing % 2 == 0 && resultDestRing != 0) {
                continue;
            }
            // если возможный ход на пустой стержень, то лучше выбрать тот, который на полный
            if (possibleDestRing == 0 && resultDestRing != 0) {
                continue;
            }
            resultSourceTower = possibleSourceTower;
            resultDestTower = possibleDestTower;
            resultSourceRing = possibleSourceRing;
            resultDestRing = possibleDestRing;
        }
        return new int[]{resultSourceTower, resultDestTower};
    }

    // полуитерационный-полурекурсивный метод
    public static void hanoiIterative(int sourceTower, int destTower) {
        // начальный ход, при четном и нечетном числе колец
        if (sourceTower == 0 && destTower == 0) {
            if (N % 2 == 0) hanoiIterative(1, 2);
            else hanoiIterative(1, 3);
        }

        // мы переложили все кольца?
        if (stack3.size() == N) return;

        // делаем текущий ход
        moveRing(sourceTower, destTower);

        //делаем новый ход
        // определаем какие блоки лежат на вершинах
        int element1 = getRing(1);
        int element2 = getRing(2);
        int element3 = getRing(3);

        // заполняем список возможных ходов
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        // можем переместить 1->2, 1->3?
        if (element1 > 0) {
            if (element2 == 0 || element1 < element2) {
                possibleMoves.add(new int[]{1, 2});
            }
            if (element3 == 0 || element1 < element3) {
                possibleMoves.add(new int[]{1, 3});
            }
        }
        // можем переместить 2->3, 2->1?
        if (element2 > 0) {
            if (element3 == 0 || element2 < element3) {
                possibleMoves.add(new int[]{2, 3});
            }
            if (element1 == 0 || element2 < element1) {
                possibleMoves.add(new int[]{2, 1});
            }
        }
        // можем переместить 3->1, 3->2?
        if (element3 > 0) {
            if (element1 == 0 || element3 < element1) {
                possibleMoves.add(new int[]{3, 1});
            }
            if (element2 == 0 || element3 < element2) {
                possibleMoves.add(new int[]{3, 2});
            }
        }
        // выбираем ход
        int[] resultMove = chooseMove(possibleMoves, sourceTower, destTower);
        // делаем следующий ход
        hanoiIterative(resultMove[0], resultMove[1]);
    }
}