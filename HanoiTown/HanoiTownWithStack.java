package Algoritmi_HW.HanoiTown;

import java.util.Stack;

public class HanoiTownWithStack {


        public static void main(String[] args) {


            int countOfDisk = 3;
            Stack<Integer> stackA = new Stack();                //Используем стек из коллекции. Стеки для релиазации штифов
            Stack<Integer> stackB = new Stack();
            Stack<Integer> stackC = new Stack();

            createTown(countOfDisk, stackA);          // Создаем исходную комбинацию

            towerOfHanoiIterative(countOfDisk, stackA, stackB, stackC);
        }

        /**
         * Метод, который создает исходную комбинацию дисков
         * @param countOfDisk количество дисков
         * @param stackA штиф(стек), на который будет добавлена исходная комбинация
         */
        private static void createTown(int countOfDisk, Stack<Integer> stackA) {
            for (int i = countOfDisk; i >= 1; i--) {   // Добавляем в стек элементы с большего к меньшему
                stackA.push(i);
                System.out.println(i);
            }
        }

        /**
         * Метод для переноса элементов в пункт назначения
         */
        private static void towerOfHanoiIterative(int countOfDisk, Stack<Integer> stackA, Stack<Integer> stackB,
                                                  Stack<Integer> stackC) {

            int moves = (int) (Math.pow(2, countOfDisk)) - 1;   // Количество операций необходимых для переноса всех дисков
            String a = "stackA";                           // Название стеков
            String b = "stackB";
            String c = "stackC";

            for (int i = 1; i <= moves; i++) {         // Рассматриваем каждый ход. Определяем какой элемент с какого в какой стек перенести
                System.out.println("----------------");
                System.out.println("Step " + i);
                if (i % 3 == 1) { //movie Disk StackA to stackC
                    movieDisk(stackA, stackC, a, c);
                } else if (i % 3 == 2) { //movie Disk StackA to stackB
                    movieDisk(stackA, stackB, a, b);
                } else if (i % 3 == 0) { //movie Disk StackC to stackB
                    movieDisk(stackB, stackC, b, c);
                }
            }
        }

        /**
         * Метод для переноса диска с одного штифа(стека) на другой
         * @param stackFrom штиф(стек), с которого переносим элемент
         * @param movieTo штиф(стек), на который мы переносим элемент
         * @param from название исходного стека
         * @param to название стека, в который перенесли
         */
        private static void movieDisk(Stack stackFrom, Stack movieTo, String from, String to) {
            int topstack = stackFrom.empty() ? 0 : (int) stackFrom.pop();  // Если текущий стек пуст, присваиваем ноль, в противном случае вершину стека
            int topstackB = movieTo.empty() ? 0 : (int) movieTo.pop(); //Если стек назначения пуст, присваиваем о, в противном случае вершину стека

            if (topstack == 0) { // переместить диск c 'helper' на 'source'
                stackFrom.push(topstackB);
                print(topstackB, to, from);
            } else if (topstackB == 0) { // переместить диск с 'source' на 'destination'
                movieTo.push(topstack);
                print(topstack, from, to);
            } else if (topstack > topstackB) { // переместить диск с 'helper' на 'destination'
                stackFrom.push(topstack);
                stackFrom.push(topstackB);
                print(topstackB, to, from);
            } else if (topstack < topstackB) { /// переместить диск с 'helper' на 'destination'
                movieTo.push(topstackB);
                movieTo.push(topstack);
                print(topstack, from, to);
            }
        }

        private static void print(int disk, String from, String to) {
            System.out.println("Move the disk " + disk + " from " + from + " to " + to);
        }
    }


