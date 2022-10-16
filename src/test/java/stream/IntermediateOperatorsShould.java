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

public class IntermediateOperatorsShould {

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
                .peek(sideEffect) // creates Side Effect
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
                .limit(3) // first 3 elements
                .collect(toList());


        final List<Integer> expectedResult = new LinkedList<>();
        expectedResult.add(84);
        expectedResult.add(89);
        expectedResult.add(109);
        /*expectedResult.add(109);
        expectedResult.add(115);*/
        assertThat(sortedScoredGoals).isEqualTo(expectedResult);


        final List<Integer> reversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(Collections.reverseOrder())
                .skip(3) // skips 3 first elements
                .collect(toList());

        final List<Integer> expectedResult_2 = new LinkedList<>();
        /*expectedResult_2.add(115);
        expectedResult_2.add(109);
        expectedResult_2.add(109);*/
        expectedResult_2.add(89);
        expectedResult_2.add(84);
        assertThat(reversedSortedScoredGoals).isEqualTo(expectedResult_2);

        final List<Integer> fourthReversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(Collections.reverseOrder())
                .skip(3) // skips 3 first elements
                .limit(1) // then pick the 4th element
                .collect(toList());

        final List<Integer> expectedResult_3 = new LinkedList<>();
        expectedResult_3.add(89);
        assertThat(fourthReversedSortedScoredGoals).isEqualTo(expectedResult_3);
    }

    @Test
    void be_lazy() {
        List<Integer> goals = players.stream()
                .map(Player::getGoal)
                .peek(goal -> System.out.println("Before filter" + " " + goal)) // will run
                .filter(goal -> goal < 50) // won't run anything after this filter
                .peek(goal -> System.out.println("After filter" + " " + goal)) // won't run
                .map(goal -> goal * 2) // won't run
                .collect(toList());

        assertThat(goals).isEmpty();
    }
}