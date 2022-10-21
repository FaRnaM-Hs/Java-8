package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.junit.jupiter.api.Test;

public class OptionalShould {

    @Test
    void avoid_null_problems() {

        // Before Java 8
        Team team = new Team();
        if (team != null) {
            Coach coach = team.getCoach();
            if (coach != null) {
                Degree degree = coach.getDegree();
                if (degree != null) {
                    String value = degree.getValue();

                    System.out.println(value);
                }
            }
        }
    }
}
