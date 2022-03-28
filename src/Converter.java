public class Converter {

    static double convertDistance(double totalSteps) {
        return totalSteps * 0.75 / 1000;
    }

    static double convertCalories(double totalSteps) {
        return totalSteps * 50 / 1000;
    }
}
