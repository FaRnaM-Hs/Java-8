package functional.interfaces;

import football.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.*;

public class SupplierShould {

    @Test
    void have_any_entry_and_return_a_type() {
        Supplier<Player> hossein = () -> new Player("Hossein", 95);

        Assertions.assertThat(hossein.get().getName()).isEqualTo("Hossein");
        Assertions.assertThat(hossein.get().getGoal()).isEqualTo(95);

        int var = -1;

        Supplier<Integer> abs = () -> Math.abs(var);
        int result = abs.get();

        Assertions.assertThat(result).isEqualTo(1);

//        IntSupplier intSupplier;
//        DoubleSupplier doubleSupplier;
//        LongSupplier longSupplier;
//        BooleanSupplier booleanSupplier;
    }
}
