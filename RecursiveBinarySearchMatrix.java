package Algoritmi_HW;

public class RecursiveBinarySearchMatrix {

    public static void main(String[] args) {

        System.out.println(powerLogN(2, 3));
        System.out.println(powerRecursive(2, 3));
        int[] arr = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        System.out.println(findElement(arr, arr2, k));
        int arr3[] = {1, 1, 2, 2, 2, 2, 3,};
        System.out.println(binarySearch(arr3));
        int [][] matrix = {{10,20,25} ,{21,30,12},{7,16,32} };
        System.out.println(findPeakElement(matrix));
    }

    /**
     * 1 уровень сложности: 1. Даны два целых числа x и n,
     * напишите функцию для вычисления x^n
     * решение 1 - рекурсивно O(n)
     * решение 2 - улучшить решение 1 до O(lon n)
     */
    public static int powerLogN(int a, int b) {
        return (int) Math.pow(a, b);
    }

    public static int powerRecursive(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a * powerRecursive(a, b - 1);
    }

    /**
     * Имея два отсортированных массива размера m и n соответственно,
     * вам нужно найти элемент, который будет находиться на k-й позиции в
     * конечном отсортированном массиве.
     * Массив 1 - 100 112 256 349 770
     * Массив 2 - 72 86 113 119 265 445 892
     * к = 7
     * Вывод : 256
     * Окончательный отсортированный массив -
     * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
     * 7-й элемент этого массива равен 256.
     */

    private static int findElement(int[] arr, int[] arr2, int k) {

        int arr3[] = new int[arr.length + arr2.length];
        int a = 0;
        int b = 0;
        int count = 0;

        while (count < arr3.length - 1) {
            if (arr[a] > arr2[b]) {
                arr3[count] = arr2[b];
                count++;
                b++;
            } else if (arr[a] < arr2[b]) {
                arr3[count] = arr[a];
                count++;
                a++;
            }
        }
        while (a < arr.length) {
            arr3[count] = arr[a];
            a++;
            count++;
        }
        while (b < arr2.length) {
            arr3[count] = arr2[b];
            b++;
            count++;
        }
        k = arr3[k];
        return k;
    }

    /**
     * Имея отсортированный массив arr[] и число x,
     * напишите функцию, которая подсчитывает вхождения x в arr[].
     * Ожидаемая временная сложность O(Log n)
     * arr[] = {1, 1, 2, 2, 2, 2, 3,}
     * x = 2
     * Вывод: 4 раза
     */
    private static int binarySearch(int[] arr) {

        int searching = 2;
        int middle = arr.length / 2;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[middle] == searching) && (arr.length / 2 <= middle)) {
                count++;
                middle++;
            } else if (arr[middle] > searching) {
                middle = arr.length / 2 - 1;
            } else if ((arr[middle] == searching) && (arr.length / 2 > middle)) {
                count++;
                middle--;
            } else if (arr[middle] < searching) {
                return count;
            }
        }
        return count;
    }
    /**
     * 4* Найдите пиковый элемент в двумерном массиве
     * Элемент является пиковым, если он больше или равен своим четырем соседям слева,
     * справа, сверху и снизу. Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1]
     * и A[i][j+1 ]. Для угловых элементов отсутствующие соседи считаются отрицательными
     * бесконечными значениями.
     * 10 20 15
     * 21 30 14
     *  7 16 32
     * Выход: 30
     * 30 — пиковый элемент, потому что все его
     * соседи меньше или равны ему.
     * 32 также можно выбрать в качестве пика.
     *
     * note
     * 1 Смежная диагональ не считается соседней.
     * 2 Пиковый элемент не обязательно является максимальным элементом.
     * 3 Таких элементов может быть несколько.
     * 4 Всегда есть пиковый элемент.
     */
    public static int findPeakElement(int[][] arr) {
        int l = 0;
        int r = arr[0].length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int maxRow = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][m] > arr[maxRow][m]) {
                    maxRow = i;
                }
            }
            if (m == 0 || arr[maxRow][m] >= arr[maxRow][m-1] && (m == arr[0].length-1 || arr[maxRow][m] >= arr[maxRow][m+1])) {
                return arr[maxRow][m];
            } else if (m > 0 && arr[maxRow][m-1] > arr[maxRow][m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}