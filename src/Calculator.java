import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Calculator {
    private double value;
    private final Character[] POSSIBLE_OPERATIONS = new Character[] {'+', '-', '*', '/'};

    Calculator() {
        this.value = 0;
    }

    Calculator(double value) {
        this.value = value;
    }

    public void calculate(char operation, double operand) throws Exception {
        if (Arrays.stream(POSSIBLE_OPERATIONS).noneMatch(character -> character.equals(operation))) {
            throw new Exception("Неизвестная операция: " + operation + ". Возможны слудющие: " + Arrays.toString(this.POSSIBLE_OPERATIONS));
        }

        switch (operation) {
            case '+':
                this.value += operand;
                break;

            case '-':
                this.value -= operand;
                break;

            case '*':
                this.value *= operand;
                break;

            case '/':
                if (operand == 0) {
                    throw new Exception("Нельзя делить на 0!");
                }
                this.value /= operand;
                break;
        }

        return;
    }

    public double getValue() {
        return this.value;
    }

    public void clearValue() {
        this.value = 0;
    }
}
