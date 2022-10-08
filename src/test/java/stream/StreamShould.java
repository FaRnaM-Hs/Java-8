package stream;

import football.player.Player;
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

        final Stream<Player> listStream = getPlayers().stream();
        // No Asserts

        Integer[] arrayStream = new Integer[5];
        final Stream<Integer> numbersStream = Arrays.stream(arrayStream);
        // No Asserts
    }

    private List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();    // Golzanan
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Cristiano Ronaldo", 115));
        scorers.add(new Player("Ferenc Puskás", 84));
        scorers.add(new Player("Mokhtar Dahari", 89));
        return scorers;
    }
}