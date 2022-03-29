import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(10000);

        int userInput;

        while (true) {
            printMenu();
            userInput = checkInput(scanner);

            if (userInput == 1) {
                handleDataInput(scanner, stepTracker);
                System.out.println();

            } else if (userInput == 2) {
                int monthNumber;

                monthNumber = printMonthSelection(scanner);

                stepTracker.showDailySteps(monthNumber);
                stepTracker.showTotalSteps(monthNumber);
                stepTracker.showMaxSteps(monthNumber);
                stepTracker.showAverageSteps();
                stepTracker.showDistanceTravelled();
                stepTracker.showCaloriesBurned();
                stepTracker.showBestSeries(monthNumber);
                System.out.println();

            } else if (userInput == 3) {
                handleNewStepsTarget(scanner, stepTracker);
                System.out.println("Новое целевое количество шагов: " + stepTracker.targetStepsCount);
                System.out.println();

            } else if (userInput == 0) {
                System.out.println("Программа завершена.");
                return;

            } else {
                System.out.println("Такой команды нет.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    static void handleDataInput(Scanner scanner, StepTracker stepTracker) {
        int monthNumber;
        int dayNumber;
        int newStepsInput;

        monthNumber = printMonthSelection(scanner);

        while (true) {
            System.out.println("Введите номер дня от 1 до 30:");

            dayNumber = checkInput(scanner);
            System.out.println();

            if (dayNumber >= 0 && dayNumber <= 29) {
                    break;
            }
            System.out.println("Необходимо ввести номер дня от 1 до 30.");
        }

        while (true) {
            System.out.println("Введите новое количество шагов:");

            newStepsInput = checkInput(scanner);
            System.out.println();

            if (newStepsInput >= 0) {
                break;
            }
            System.out.println("Необходимо ввести 0 или неотрицательное число.");
        }

        stepTracker.addMonthData(monthNumber, dayNumber, newStepsInput);
    }

    static int printMonthSelection(Scanner scanner) {
        System.out.println("Введите номер месяца:");
        System.out.println("0 - Январь");
        System.out.println("1 - Февраль");
        System.out.println("2 - Март");
        System.out.println("3 - Апрель");
        System.out.println("4 - Май");
        System.out.println("5 - Июнь");
        System.out.println("6 - Июль");
        System.out.println("7 - Август");
        System.out.println("8 - Сентябрь");
        System.out.println("9 - Октябрь");
        System.out.println("10 - Ноябрь");
        System.out.println("11 - Декабрь");

        int monthNumber;

        while (true) {

            monthNumber = checkInput(scanner);
            System.out.println();

            if (monthNumber >= 0 && monthNumber <= 11) {
                    break;
            }
            System.out.println("Необходимо ввести номер месяца от 0 до 11.");
        }
        return monthNumber;
    }

    static void handleNewStepsTarget(Scanner scanner, StepTracker stepTracker) {
        int newTargetStepsCount;

        while (true) {
            System.out.println("Введите новое целевое количество шагов:");

            newTargetStepsCount = checkInput(scanner);
            System.out.println();

            if (newTargetStepsCount >= 0) {
                break;
            }
            System.out.println("Необходимо ввести 0 или неотрицательное число.");
        }

        stepTracker.changeTargetStepsCount(newTargetStepsCount);
    }

    static int checkInput (Scanner scanner) {
        int testedInput = -1;

        try {
            testedInput = Integer.parseInt(scanner.next());
        }
        catch (NumberFormatException exception) {
            System.out.println("Ошибка: введен текст.");
        }
        return testedInput;
    }

}