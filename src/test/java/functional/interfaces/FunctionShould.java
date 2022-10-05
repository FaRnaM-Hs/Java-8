package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionShould {

    @Test
    void get_an_entry_and_produce_an_output() {
        Map<String, Integer> map = new HashMap<>();
        Function<? super String, Integer> function = String::length;
        Integer result = map.computeIfAbsent("Java", function);

        Assertions.assertThat(result).isEqualTo(4);
    }
}
