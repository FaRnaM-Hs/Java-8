package file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileShould {

    @Test
    void read_a_file_line_by_line() {
        LineByLineFileReader reader = new LineByLineFileReader("test.txt");

        String content = reader.readFile();

        Assertions.assertThat(content).isEqualTo("line 1\nline 2\nline 3\nline 4\nline 5");
    }
}
