package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class OptionalShould {

    @Test
    void avoid_null_problems() {
        Team team = new Team(new Coach(new Degree("A")));

        // Before java 8
/*        if (team != null) {
            final Optional<Coach> coach = team.getCoach();
            if (coach.isPresent()) {
                final Optional<Degree> degree = coach.get().getDegree();
                final String value = degree.get().getValue();
                assertThat(value).isEqualTo(null);
            }
        }*/

        // From java 8
        team.getCoach()
                .flatMap(Coach::getDegree)
                .map(Degree::getValue)
                .ifPresent(value -> assertThat(value).isEqualTo("A"));
    }

    @Test
    void be_created() {
        String name = "Farnam";

        Assertions.assertThat(Optional.of(name).get()).isEqualTo("Farnam");

        String nullName = null;

        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Optional.of(nullName));

        Assertions.assertThat(Optional.ofNullable(nullName)).isEmpty();
    }
}
