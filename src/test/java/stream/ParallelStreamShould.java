package stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamShould {

    @Test
    void be_predictable() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Sequential result is:");
        integers.stream().forEach(System.out::print);

        System.out.println("\nParallel result is:");
        integers.parallelStream().forEach(System.out::print);

        Integer sequentialSum = integers.stream().reduce(5, Integer::sum);
        Assertions.assertThat(sequentialSum).isEqualTo(20); // 1 + 2 + 3 + 4 + 5

        Integer parallelSum = integers.parallelStream().reduce(5, Integer::sum);
        Assertions.assertThat(parallelSum).isEqualTo(40); // (5 + 1) + (5 + 2) + (5 + 3) + (5 + 4) + (5 + 5)
    }
}
