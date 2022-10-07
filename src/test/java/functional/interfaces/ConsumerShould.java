package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerShould {

    @Test
    void takes_entries_and_return_nothing() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);

        Consumer<Integer> consumer = System.out::println;
        numbers.forEach(consumer);

        // No Asserts

        List<Integer> newNumbers = new ArrayList<>();

        Consumer<Integer> copy = newNumbers::add;
        numbers.forEach(copy);

        Assertions.assertThat(newNumbers).isEqualTo(numbers);

//        IntConsumer intConsumer;
//        DoubleConsumer doubleConsumer;
//        LongConsumer longConsumer;
    }
}
