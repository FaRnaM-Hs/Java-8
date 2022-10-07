package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class BiConsumerShould {

    @Test
    void takes_two_entries_and_return_nothing() {
        Map<String, Integer> copyPlayers = new HashMap<>();
        Map<String, Integer> players = new HashMap<>();
        players.put("Karimi", 50);
        players.put("Bagheri", 70);

        BiConsumer<? super String, ? super Integer> biConsumer =
                (key, value) -> System.out.println("Player name is " + key + " and scored " + value + " goals.");
        players.forEach(biConsumer);

        // No Asserts

        BiConsumer<? super String, ? super Integer> copy = copyPlayers::put;

        players.forEach(copy);

        Assertions.assertThat(copyPlayers).isEqualTo(players);

//        ObjLongConsumer objLongConsumer;
//        ObjIntConsumer objIntConsumer;
//        ObjDoubleConsumer objDoubleConsumer;
    }
}
