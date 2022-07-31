package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PureFunctionShould {

    @Test
    void depends_only_on_its_parameter() {
        PureMethod pureMethod = new PureMethod();

        int sum1 = pureMethod.sum(1, 3);

        Assertions.assertThat(sum1).isEqualTo(4);

        ImpureMethod impureMethod = new ImpureMethod();

        int sum2 = impureMethod.sum(1, 3);

        Assertions.assertThat(sum2).isEqualTo(9);
    }

    @Test
    void has_no_side_effect() {
        ImpureMethod impureMethod = new ImpureMethod();

        int sum1 = impureMethod.sum(1, 3);

        Assertions.assertThat(sum1).isEqualTo(9);

        int result = impureMethod.impure_2(2, 3);

        Assertions.assertThat(result).isEqualTo(5);

        int sum2 = impureMethod.sum(1, 3);

        Assertions.assertThat(sum2).isEqualTo(9);
    }
}
