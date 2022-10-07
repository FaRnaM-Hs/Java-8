package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicateShould {

    @Test
    void take_a_type_as_entry_and_return_a_boolean() {
        int var = 10;

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        final boolean result = isEven.test(var);

        Assertions.assertThat(result).isTrue();
    }
}
