package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(playersWithID.values()).hasSameElementsAs(players);
        assertThat(playersWithID.keySet()).hasOnlyElementsOfType(UUID.class);
    }

    @Test
    void calculate_data() {
        ToIntFunction<Integer> intConverter = Integer::valueOf;

        final Integer sum = players.stream()
                .map(Player::getGoal)
                .mapToInt(intConverter)
                .sum();

        assertThat(sum).isEqualTo(506);

        final Double average = players.stream()
                .map(Player::getGoal)
                .collect(Collectors.averagingInt(intConverter));

        assertThat(average).isEqualTo(101.2);

        final Optional<Integer> max = players.stream()
                .map(Player::getGoal)
                .max(Comparator.naturalOrder());

        assertThat(max.get()).isEqualTo(115);

        final Optional<Integer> min = players.stream()
                .map(Player::getGoal)
                .min(Comparator.naturalOrder());

        assertThat(min.get()).isEqualTo(84);

        final Long numberOfPlayers = players.stream()
                .map(Player::getGoal)
                .count();

        assertThat(numberOfPlayers).isEqualTo(5);

        final IntSummaryStatistics summary = players.stream()
                .map(Player::getGoal)
                .collect(Collectors.summarizingInt(intConverter));

        assertThat(summary.getSum()).isEqualTo(506);
        assertThat(summary.getAverage()).isEqualTo(101.2);
        assertThat(summary.getMax()).isEqualTo(115);
        assertThat(summary.getMin()).isEqualTo(84);
        assertThat(summary.getCount()).isEqualTo(5);
    }

    @Test
    void group_data() {
        Function<Player, String> playerName = Player::getName;
        Map<String, Long> groupedPlayers = players.stream()
                .collect(Collectors.groupingBy(playerName, Collectors.counting()));
        groupedPlayers.forEach((k, v) -> System.out.println("Player is " + k + " and has " + v + " occurrences"));

        assertThat(groupedPlayers)
                .containsEntry("Ali Daei", 2L)
                .containsEntry("Cristiano Ronaldo", 1L)
                .containsEntry("Ferenc Puskás", 1L)
                .containsEntry("Mokhtar Dahari", 1L);
    }

    @Test
    void match_data() {
        // All match
        Predicate<Integer> moreThan50Goals = goals -> goals > 50;
        boolean allPlayersScoredMoreThan50 = players.stream()
                .map(Player::getGoal)
                .allMatch(moreThan50Goals);

        assertThat(allPlayersScoredMoreThan50).isTrue();

        // Any match
        Predicate<Integer> moreThan100Goals = goals -> goals > 100;
        boolean anyPlayerScoredMoreThan100 = players.stream()
                .map(Player::getGoal)
                .anyMatch(moreThan100Goals);

        assertThat(anyPlayerScoredMoreThan100).isTrue();

        // None match
        Predicate<Integer> noGoals = goals -> goals == 0;
        boolean nonePlayerScoredNoGoals = players.stream()
                .map(Player::getGoal)
                .noneMatch(noGoals);

        assertThat(nonePlayerScoredNoGoals).isTrue();
    }

    @Test
    void find_data() {
        Optional<String> firstScorerLessThan100Goals = players.stream()
                .filter(player -> player.getGoal() < 100)
                .map(Player::getName)
                .findFirst();

        assertThat(firstScorerLessThan100Goals.get()).isEqualTo("Ferenc Puskás");

        Optional<String> anyScorerLessThan100Goals = players.stream()
                .filter(player -> player.getGoal() < 100)
                .map(Player::getName)
                .findAny();

        assertThat(anyScorerLessThan100Goals.get()).satisfiesAnyOf(
                player -> player.equals("Ferenc Puskás"),
                player -> player.equals("Mokhtar Dahari")
        );
    }

    @Test
    void reduce_data() {
        BinaryOperator<Integer> sumOfGoals = Integer::sum;
        final Integer totalGoals = players.stream().map(Player::getGoal).reduce(0, sumOfGoals);

        assertThat(totalGoals).isEqualTo(506);

        final String formattedNames = players.stream()
                .map(Player::getName)
                .reduce("", this::format)
                .substring(3);

        assertThat(formattedNames).isEqualTo("Ali DAEI | Ali DAEI | Cristiano RONALDO | Ferenc PUSKÁS | Mokhtar DAHARI");
    }

    private String format(String result, String playerName) {
        return result + " | " + playerName.split(" ")[0] + " " + playerName.split(" ")[1].toUpperCase();
    }
}
