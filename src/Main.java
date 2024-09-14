import java.util.Scanner;

public class Main {
    private static Calculator calculator;
    private static Scanner scanner;

    public static void main(String[] args) {
        CalculatorTester calculatorTester = new CalculatorTester();
        System.out.println("Проверяем работоспособность калькулятора...");
        boolean testSuccess = calculatorTester.test();
        if (testSuccess) {
            System.out.println("Калькулятор исправен. Можно пользоваться!\n");
        } else {
            logError("Калькулятор неисправен. Им нельзя пользоваться.");
            System.exit(1);
        }

        scanner = new Scanner(System.in);
        System.out.println("Вы запустили калькулятор! Что хотите посчитать? Для выхода введите Q.");

        double initialValue = 0;
        char operation = '+';
        double operand = 0;

        boolean inputIsCorrect = false;
        while (!inputIsCorrect) {
            try {
                initialValue = inputDouble();
                operation = inputOperation();
                if (operation == 'Q') {
                    System.exit(0);
                }
                operand = inputDouble();

                inputIsCorrect = true;
            } catch (Exception e) {
                logError(e.getMessage());
                scanner.nextLine();
            }
        }

        calculator = new Calculator(initialValue);
        useCalculator(operation, operand);

        main:
        while (true) {
            System.out.println("Можете продолжить вычисления. Для очистки введите С. Для выхода введите Q");

            double value = calculator.getValue();
            System.out.print(value + " ");

            inputIsCorrect = false;
            while (!inputIsCorrect) {
                try {
                    operation = inputOperation();
                    switch (operation) {
                        case 'Q':
                            System.exit(0);

                        case 'C':
                            calculator.clearValue();
                            continue main;

                        default:
                            break;
                    }
                    operand = inputDouble();

                    inputIsCorrect = true;
                } catch (Exception e) {
                    logError(e.getMessage());
                    scanner.nextLine();
                    continue main;
                }
            }


            useCalculator(operation, operand);

        }
    }


    private static void useCalculator(char operation, double operand) {
        try {
            calculator.calculate(operation, operand);
        } catch (Exception e) {
            logError(e.getMessage());
        }
    }

    private static double inputDouble() throws Exception {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            throw new Exception("Числа и операции нужно вводить через пробел. Попробуйте еще.");
        }

    }

    private static char inputOperation() throws Exception {
        String operationFromConsole = scanner.next();
        if (operationFromConsole.length() > 1) {
            throw new Exception("Числа и операции нужно вводить через пробел. Попробуйте еще.");
        }

        return operationFromConsole.charAt(0);
    }

    private static void logError(String msg) {
        System.out.println("\033[0;31m" + msg + "\033[0m");
    }
}