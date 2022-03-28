import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            printMenu();
            userInput = scanner.nextInt();
            System.out.println();

            if (userInput == 1) {
                handleDataInput(scanner);
                System.out.println();

            } else if (userInput == 2) {
                int monthNumber;

                monthNumber = printMonthSelection(scanner);

                StepTracker.showDailySteps(monthNumber);
                StepTracker.showTotalSteps(monthNumber);
                StepTracker.showMaxSteps(monthNumber);
                StepTracker.showAverageSteps();
                StepTracker.showDistanceTravelled();
                StepTracker.showCaloriesBurned();
                StepTracker.showBestSeries(monthNumber);
                System.out.println();

            } else if (userInput == 3) {
                handleNewStepsTarget(scanner);
                System.out.println("Новое целевое количество шагов: " + StepTracker.targetStepsCount);
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

    static void handleDataInput(Scanner scanner) {
        int monthNumber;
        int dayNumber;
        int newStepsInput;

        monthNumber = printMonthSelection(scanner);

        while (true) {
            System.out.println("Введите номер дня от 1 до 30:");
            dayNumber = scanner.nextInt() - 1;
            System.out.println();

            if (dayNumber >= 0) {
                if (dayNumber <= 29) {
                    break;
                }
            }
            System.out.println("Такого номера нет.");
        }

        while (true) {
            System.out.println("Введите новое количество шагов:");
            newStepsInput = scanner.nextInt();
            System.out.println();

            if (newStepsInput >= 0) {
                break;
            }
            System.out.println("Количество шагов не должно быть отрицательным.");
        }

        StepTracker.addMonthData(monthNumber, dayNumber, newStepsInput);
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
            monthNumber = scanner.nextInt();

            if (monthNumber >= 0) {
                if (monthNumber <= 11) {
                    break;
                }
            }
            System.out.println("Такого номера нет.");
        }
        System.out.println();
        return monthNumber;
    }

    static void handleNewStepsTarget(Scanner scanner) {
        int newTargetStepsCount;

        while (true) {
            System.out.println("Введите новое целевое количество шагов:");
            newTargetStepsCount = scanner.nextInt();
            System.out.println();

            if (newTargetStepsCount >= 0) {
                break;
            }
            System.out.println("Количество шагов не должно быть отрицательным.");
        }

        StepTracker.changeTargetStepsCount(newTargetStepsCount);
    }

}