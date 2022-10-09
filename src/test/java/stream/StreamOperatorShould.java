package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperatorShould {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void filter_data() {
        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        Consumer<? super Player> sideEffect = System.out::println;
        final List<Player> topScorersWhichNameContainsAli = players.stream()
                .filter(topScorer)
                .peek(sideEffect)
                .filter(nameIsAli)
                .distinct() // removes duplicated datas
                .collect(toList());

        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei", 109));
        assertThat(topScorersWhichNameContainsAli).isEqualTo(aliDaei);
    }

    @Test
    void map_data() {
        Function<? super Player, ?> function = Player::getName;
        final List<?> playersNames = players.stream()
                .map(function)
                .distinct() // removes duplicated datas
                .collect(toList());

        final List<String> expectedResult = new LinkedList<>();
        expectedResult.add("Ali Daei");
        expectedResult.add("Cristiano Ronaldo");
        expectedResult.add("Ferenc Puskás");
        expectedResult.add("Mokhtar Dahari");
        assertThat(playersNames).isEqualTo(expectedResult);
    }

    @Test
    void sort_data() {
        final List<Integer> sortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted()
                .collect(toList());


        final List<Integer> expectedResult = new LinkedList<>();
        expectedResult.add(84);
        expectedResult.add(89);
        expectedResult.add(109);
        expectedResult.add(109);
        expectedResult.add(115);
        assertThat(sortedScoredGoals).isEqualTo(expectedResult);


        final List<Integer> reversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(Collections.reverseOrder())
                .collect(toList());

        final List<Integer> expectedResult_2 = new LinkedList<>();
        expectedResult_2.add(115);
        expectedResult_2.add(109);
        expectedResult_2.add(109);
        expectedResult_2.add(89);
        expectedResult_2.add(84);
        assertThat(reversedSortedScoredGoals).isEqualTo(expectedResult_2);
    }
}