package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

public class BinaryOperatorShould {

    @Test
    void have_two_entries_and_one_output_with_the_same_type() {
        int var1 = 5;
        int var2 = 10;

        BinaryOperator<Integer> binaryOperator = (integer1, integer2) -> integer1 * integer2;
        Integer result = binaryOperator.apply(var1, var2);

        Assertions.assertThat(result).isEqualTo(50);
    }
}
