public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++){
            System.out.println((i+1) + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth(){
        int sumSteps = 0;
        for (int day : days) {
            sumSteps = sumSteps + day;
        }
        return sumSteps;
    }

    public int maxSteps(){
        int maxSteps = 0;
        for (int i = 0; i < days.length/2 + 1; i++){
            int rigth = days[days.length - i-1];
            int left = days[i];
            if (left > rigth && left > maxSteps){
                maxSteps = left;
            }else if (rigth > maxSteps){
                maxSteps = rigth;
            }
        } return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay){
        int bestSeries = 0;
        int currentSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > bestSeries) {
                bestSeries = currentSeries;
            }
        }
        return bestSeries;
    }

}
