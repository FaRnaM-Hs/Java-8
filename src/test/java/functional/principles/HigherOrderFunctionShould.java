package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HigherOrderFunctionShould {

    @Test
    void take_one_or_many_other_function_as_parameter_and_return_a_function() {
        Operation operation = number -> number + 5;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        int result = addOperationTo.apply();
        Assertions.assertThat(result).isEqualTo(7);

        Operation power = number -> number * number;
        AddOperationTo toPower = addOperationTo(5, power);
        int powerResult = toPower.apply();

        Assertions.assertThat(powerResult).isEqualTo(25);
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }


    @FunctionalInterface
    interface AddOperationTo {
        int apply();
    }

    @FunctionalInterface
    interface Operation {
        int applyOperation(int number);

        default int another(int number) {
            return 0;
        }
    }
}
