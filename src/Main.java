import java.util.Scanner;

/* Привет, спасибо за положительный отзыв, очень приятно! :)
   Вроде всё поправил. */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker stepTracker = new StepTracker(scanner);

        while (true){
            int command = scanner.nextInt();
            if (command == 1){
                stepTracker.addNewNumberStepsPerDay();
                printMenu();
            }else if (command == 2){
                stepTracker.changeStepGoal();
                printMenu();
            }else if (command == 3) {
                stepTracker.printStatistic();
                printMenu();
            }else if (command == 0){
                scanner.close();
                break;
            } else {
                System.out.println("Такой команды ещё нет");
            }
        }
    }

    static void printMenu(){
        System.out.println("Что вы хотите сделать? Введите цифру:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день;");
        System.out.println("3 - Напечатать статистику за определённый месяц;");
        System.out.println("0 - Выйти из приложения.");
    }

}
