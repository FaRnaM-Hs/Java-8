package football.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PlayerShould {

    @Test
    void give_the_best_scorer_with_OOP() {
        List<Player> scorers = getPlayers();

        Player bestScorer = scorers.get(0);
        for (Player scorer : scorers) {
            if (scorer.getGoal() > bestScorer.getGoal()) {
                bestScorer = scorer;
            }
        }

        Assertions.assertThat(bestScorer.getName()).isEqualTo("Cristiano Ronaldo");
    }

    @Test
    void give_the_best_scorer_with_FP() {
        List<Player> scorers = getPlayers();

        Player bestScorer = scorers.stream()
                .max(Comparator.comparing(player -> player.getGoal()))
                .get();

        Assertions.assertThat(bestScorer.getName()).isEqualTo("Cristiano Ronaldo");
    }

    private List<Player> getPlayers() {
        List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Cristiano Ronaldo", 115));
        scorers.add(new Player("Ferenc Puskás", 84));
        scorers.add(new Player("Mokhtar Dahari", 89));
        return scorers;
    }
}
