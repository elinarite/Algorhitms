package Algoritmi_HW.HanoiTown;

public class HanoiTownRecursive {


    public static void main(String[] args) {

        move(3, 1, 3);
    }
    public static void move(int n, int startTown, int endTown) {
        if (n == 0) {
            return;
        }
        int tempTown = 6 - startTown - endTown;
        move(n - 1, startTown, tempTown);
        System.out.println("Move " + n + " from " + startTown + " to " + endTown);
        move(n - 1, tempTown, endTown);
    }



}

