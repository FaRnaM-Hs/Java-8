package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsShould {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void collect_data() { // toList, toMap, toSet, toArray, toCollection
        Function<Player, UUID> keys = player -> UUID.randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithID = players.stream()
                .collect(Collectors.toMap(keys, values));
        BiConsumer<UUID, Player> printPlayers = (k, v) -> System.out.println("Key is: " + k + " Value is: " + v);
        playersWithID.forEach(printPlayers);

        Assertions.assertThat(playersWithID.values()).hasSameElementsAs(players);
        Assertions.assertThat(playersWithID.keySet()).hasOnlyElementsOfType(UUID.class);
    }

    @Test
    void calculate_data() {
        ToIntFunction<Integer> intConverter = Integer::valueOf;

        final Integer sum = players.stream()
                .map(Player::getGoal)
                .mapToInt(intConverter)
                .sum();

        Assertions.assertThat(sum).isEqualTo(506);

        final Double average = players.stream()
                .map(Player::getGoal)
                .collect(Collectors.averagingInt(intConverter));

        Assertions.assertThat(average).isEqualTo(101.2);

        final Optional<Integer> max = players.stream()
                .map(Player::getGoal)
                .max(Comparator.naturalOrder());

        Assertions.assertThat(max.get()).isEqualTo(115);

        final Optional<Integer> min = players.stream()
                .map(Player::getGoal)
                .min(Comparator.naturalOrder());

        Assertions.assertThat(min.get()).isEqualTo(84);

        final Long numberOfPlayers = players.stream()
                .map(Player::getGoal)
                .count();

        Assertions.assertThat(numberOfPlayers).isEqualTo(5);

        final IntSummaryStatistics summary = players.stream()
                .map(Player::getGoal)
                .collect(Collectors.summarizingInt(intConverter));

        Assertions.assertThat(summary.getSum()).isEqualTo(506);
        Assertions.assertThat(summary.getAverage()).isEqualTo(101.2);
        Assertions.assertThat(summary.getMax()).isEqualTo(115);
        Assertions.assertThat(summary.getMin()).isEqualTo(84);
        Assertions.assertThat(summary.getCount()).isEqualTo(5);
    }
}
