import java.util.Scanner;

public class StepTracker {
    MonthData[] monthData = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10000;


    StepTracker(Scanner scan){
        scanner = scan;
        for (int i=0; i < monthData.length; i++){
            monthData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay(){
        System.out.println("Введите номер месяца, от 1 до 12");
        int month = scanner.nextInt() - 1;
        if (month < 0 || month > 11){
            System.out.println("Номер месяца не может быть меньше 1 или больше 12");
            return;
        }
        System.out.println("Введите день, от 1 до  30");
        int day = scanner.nextInt() - 1;
        if (day < 0 || day > 29){
            System.out.println("Номер дня не может быть меньше 1 или больше 30");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0){
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }
        monthData[month].days[day] = steps;
    }

    public void changeStepGoal(){
        System.out.println("Введите новую цель по шагам за день");
        int newGoal = scanner.nextInt();
        if (newGoal > 0){
            goalByStepsPerDay = newGoal;
        } else {
            System.out.println("Цель по шагам не может быть меньше 0 или 0");
        }
    }

    public void printStatistic(){
        Converter converter = new Converter();
        System.out.println("Выберите месяц, от 1 до 12");
        int month = scanner.nextInt() - 1;
        if (month < 0 || month > 11){
            System.out.println("Номер месяца не может быть меньше 1 или больше 12");
            return;
        }
        System.out.println("Количество пройденных шагов по дням:");
        monthData[month].printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц - " + monthData[month].sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце - " + monthData[month].maxSteps());
        System.out.println("Среднее количество шагов за день - " + monthData[month].sumStepsFromMonth()/30);
        System.out.println("Пройденная дистанция (в км) - " +
                converter.convertToKm(monthData[month].sumStepsFromMonth()));
        System.out.println("Количество сожжённых килокалорий - " +
                converter.convertStepsToKilocalories(monthData[month].sumStepsFromMonth()));
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней," +
                " в течение которых количество шагов за день было равно или выше целевого. - " +
                monthData[month].bestSeries(goalByStepsPerDay));
        System.out.println();
    }

}
