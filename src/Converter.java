public class Converter {

    public int convertToKm(int steps){
        return (int) (steps * 0.00075);
    }

    public int convertStepsToKilocalories(int steps){
        return (int) (steps * 0.05);
    }
}
