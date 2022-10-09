package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class StreamShould {

    @Test
    void be_created() {
        final String hello = "Hello";
        final Stream<String> objectStream = Stream.of(hello);
        // No Asserts

        final Stream<Player> listStream = new PlayerTestHelper().getPlayers().stream();
        // No Asserts

        Integer[] arrayStream = new Integer[5];
        final Stream<Integer> numbersStream = Arrays.stream(arrayStream);
        // No Asserts
    }
}