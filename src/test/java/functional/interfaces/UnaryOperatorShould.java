package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

public class UnaryOperatorShould {

    @Test
    void has_the_same_type_as_entry_and_output() {
        int var = 5;

        UnaryOperator<Integer> power = integer -> integer * integer;
        Integer result = power.apply(var);

        Assertions.assertThat(result).isEqualTo(25);
    }
}
