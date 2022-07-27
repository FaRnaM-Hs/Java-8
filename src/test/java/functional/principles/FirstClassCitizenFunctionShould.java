package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstClassCitizenFunctionShould {

    private List<String> players;

    @BeforeEach
    void setUp() {
        players = getPlayers();
    }

    @Test
    void be_passed_as_method_parameter() {
        Collections.sort(players, (a, b) -> a.compareTo(b));

        assertPlayersSort(players);
    }

    @Test
    void be_passed_as_value_to_a_variable() {
        Comparator<String> variable = (a, b) -> a.compareTo(b);

        assertPlayersSort(players);
    }

    @Test
    void be_returned_from_a_method() {
        Comparator<String> variable = getPlayerComparator();

        assertPlayersSort(players);
    }

    private Comparator<String> getPlayerComparator() {
        return (a, b) -> a.compareTo(b);
    }


    private void assertPlayersSort(List<String> players) {
        Assertions.assertThat(players.get(0)).isEqualTo("Abedzadeh");
        Assertions.assertThat(players.get(1)).isEqualTo("Majidi");
        Assertions.assertThat(players.get(2)).isEqualTo("Ronaldo");
    }

    private List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        players.add("Ronaldo");
        players.add("Abedzadeh");
        players.add("Majidi");
        return players;
    }
}
