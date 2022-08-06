package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class BiFunctionShould {

    @Test
    void takes_two_types_as_entry_and_return_one_type() {
        Map<String, Integer> players = new HashMap<>();
        players.put("Ali", 98);
        players.put("Farnam", 100);

        BiFunction<? super String, ? super Integer, Integer> biFunction =
                (key, value) -> key.contains("n") ? value + 1 : value - 1;
        Integer ali = players.compute("Ali", biFunction);
        Integer farnam = players.compute("Farnam", biFunction);

        Assertions.assertThat(ali).isEqualTo(97);
        Assertions.assertThat(farnam).isEqualTo(101);
    }
}
