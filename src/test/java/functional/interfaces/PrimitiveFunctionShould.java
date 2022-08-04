package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.*;

public class PrimitiveFunctionShould {

    @Test
    void get_a_primitive_type_as_entry() {
        IntFunction<Long> toLong = Long::valueOf;
        Long result = toLong.apply(5);
        Assertions.assertThat(result).isEqualTo(5L);

        DoubleFunction<String> toStringDouble = String::valueOf;
        String result2 = toStringDouble.apply(18.5);
        Assertions.assertThat(result2).isEqualTo("18.5");

        LongFunction<String> toStringLong = String::valueOf;
        String result3 = toStringLong.apply(2022L);
        Assertions.assertThat(result3).isEqualTo("2022");
    }

    @Test
    void return_a_primitive_type_given_any_type() {
        ToIntFunction<String> toIntFunction = string -> Integer.valueOf(string).intValue();
        int stringToInt = toIntFunction.applyAsInt("5");
        Assertions.assertThat(stringToInt).isEqualTo(5);

        // ToDoubleFunction<Integer> toDoubleFunction;
        // ToLongFunction<Double> toLongFunction;
    }
}
