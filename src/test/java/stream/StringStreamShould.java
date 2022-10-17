package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

public class StringStreamShould {

    @Test
    void join_strings() {
        List<String> names = asList("Farnam", "Amir", "Erfan");

        String joinedNames = names.stream().collect(Collectors.joining());
        String joinedNamesWithComma = names.stream().collect(Collectors.joining(", "));
        String joinedNamesWithCommaAndBrackets = names.stream().collect(Collectors.joining(", ", "[", "]"));

        assertThat(joinedNames).isEqualTo("FarnamAmirErfan");
        assertThat(joinedNamesWithComma).isEqualTo("Farnam, Amir, Erfan");
        assertThat(joinedNamesWithCommaAndBrackets).isEqualTo("[Farnam, Amir, Erfan]");
    }

    @Test
    void join_names_with_comma_and_brackets() {
        final List<String> names = asList("Sepehr", "Ali", "Akbar");

        final String joinedNamesWithCommaAndBrackets = names.stream()
                .collect(Collectors.joining("], [", "[", "]"));

        assertThat(joinedNamesWithCommaAndBrackets).isEqualTo("[Sepehr], [Ali], [Akbar]");
    }
}
