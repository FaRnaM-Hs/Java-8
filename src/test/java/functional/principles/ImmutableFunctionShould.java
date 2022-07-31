package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableFunctionShould {

    @Test
    void never_be_changed_after_being_constructed() {
        int var = 5;
        //var++;        doesn't compile (Should be final)
        Operation operation = number -> number + var;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        int result = addOperationTo.apply();
        Assertions.assertThat(result).isEqualTo(7);
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }
}
