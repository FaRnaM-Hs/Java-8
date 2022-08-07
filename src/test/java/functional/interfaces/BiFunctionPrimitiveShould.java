package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class BiFunctionPrimitiveShould {

    @Test
    void return_a_primitive_type() {
        ToDoubleBiFunction<Integer, Integer> toDoubleFunction = Integer::sum;
        double result1 = toDoubleFunction.applyAsDouble(5, 10);
        Assertions.assertThat(result1).isEqualTo(15d);

        ToIntBiFunction<Double, Long> toIntBiFunction =
                (num1, num2) -> num1 * num2 >= 10 ? 1 : 0;
        int result2 = toIntBiFunction.applyAsInt(2.5d, 4L);
        Assertions.assertThat(result2).isEqualTo(1);

        ToLongBiFunction<Double, Float> toLongBiFunction =
                (num1, num2) -> (long) (num1 * num2);
        long result3 = toLongBiFunction.applyAsLong(5.5d, 2.3f);
        Assertions.assertThat(result3).isEqualTo(12L);
    }
}
