public class StepTracker {

    static int[][] monthToData = new int[12][30];
    static int targetStepsCount = 10000;
    static int totalSteps;

    static void addMonthData(int monthNumber, int dayNumber, int newStepsInput) {
        monthToData[monthNumber][dayNumber] = newStepsInput;
        System.out.println("Новое количество шагов за день " + (dayNumber + 1) + " месяца "
                            + monthNumber + ": " + monthToData[monthNumber][dayNumber] + ".");
    }

    static void changeTargetStepsCount(int newTargetStepsCount) {
        targetStepsCount = newTargetStepsCount;
    }

    static void showDailySteps(int monthNumber) {
        for (int i = 0; i < monthToData[monthNumber].length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[monthNumber][i] + ", ");

            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static void showTotalSteps(int monthNumber) {
        totalSteps = 0;

        for (int i = 0; i < monthToData[monthNumber].length; i++) {
            totalSteps = totalSteps + monthToData[monthNumber][i];
        }
        System.out.println("Общее количество шагов за месяц: " + totalSteps);
    }

    static void showMaxSteps(int monthNumber) {
        int maxMonthSteps = 0;

        for (int i = 0; i < monthToData[monthNumber].length; i++) {
            if (monthToData[monthNumber][i] > maxMonthSteps) {
                maxMonthSteps = monthToData[monthNumber][i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов: " + maxMonthSteps);
    }

    static void showAverageSteps() {
        System.out.println("Среднее количество шагов: " + totalSteps / 30);
    }

    static void showDistanceTravelled() {
        System.out.println("Пройденная дистанция: " + Converter.convertDistance(totalSteps) + " км");
    }

    static void showCaloriesBurned() {
        System.out.println("Количество сожженных килокалорий: " + Converter.convertCalories(totalSteps));
    }

    static void showBestSeries(int monthNumber) {
        int series = 0;
        int maxSeries = 0;

        for (int i = 0; i < monthToData[monthNumber].length; i++) {
            if (monthToData[monthNumber][i] >= targetStepsCount) {
                series = series + 1;

                if (series > maxSeries) {
                    maxSeries = series;
                }
            } else {
                series = 0;
            }
        }
        System.out.println("Лучшая серия: " + maxSeries);
    }
}
