public class CalculatorTester {
    public boolean test() {
        boolean success = true;

        success &= testAdd();
        success &= testMult();
        success &= testDiff();
        success &= testDiv();
        success &= testClearValue();
        success &= testIncorrectOperation();

        return success;
    }

    private boolean testAdd() {
        System.out.println("    Проверяем сложение");
        Calculator calculator = new Calculator(10);

        try {
            calculator.calculate('+', 1);
        } catch (Exception e) {}

        return calculator.getValue() == 11;
    }

    private boolean testMult() {
        System.out.println("    Проверяем умножение");
        Calculator calculator = new Calculator(10);

        try {
            calculator.calculate('-', 1);
        } catch (Exception e) {}


        return calculator.getValue() == 9;
    }

    private boolean testDiff() {
        System.out.println("    Проверяем разность");
        Calculator calculator = new Calculator(10);

        try {
            calculator.calculate('*', 2);
        } catch (Exception e) {}

        return calculator.getValue() == 20;
    }

    private boolean testDiv() {
        System.out.println("    Проверяем деление");
        Calculator calculator = new Calculator(10);

        try {
            calculator.calculate('/', 2);
        } catch (Exception e) {}

        return calculator.getValue() == 5;
    }

    private boolean testClearValue() {
        System.out.println("    Проверяем очистку");
        Calculator calculator = new Calculator(10);

        try {
            calculator.clearValue();
        } catch (Exception e) {}

        return calculator.getValue() == 0;
    }

    private boolean testIncorrectOperation() {
        System.out.println("    Проверяем валидацию доступных операций");
        Calculator calculator = new Calculator(10);

        try {
            calculator.calculate('_', 1);
        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
