import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RealizationSplitTest {
    @Test
    void funL() throws IOException {
        String[] arg = {"-d", "-l 10", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-d", "-l 10", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-d", "-l 10", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-d", "-l 10", "input.txt"};
        Split.main(arg3);
    }

    @Test
    void funC() throws IOException {
        String[] arg = {"-d", "-c 200", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-d", "-c 200", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-d", "-c 200", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-d", "-c 200", "input.txt"};
        Split.main(arg3);
    }

    @Test
    void funN() throws IOException {
        String[] arg = {"-d", "-n 5", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-d", "-n 5", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-d", "-n 5", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-d", "-n 5", "input.txt"};
        Split.main(arg3);
    }

    @Test
    void renameL() throws IOException {
        String[] arg = {"-l 10", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-l 10", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-l 10", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-l 10", "input.txt"};
        Split.main(arg3);
    }

    @Test
    void renameC() throws IOException {
        String[] arg = {"-c 250", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-c 250", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-c 250", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-c 250", "input.txt"};
        Split.main(arg3);
    }

    @Test
    void renameN() throws IOException {
        String[] arg = {"-n 3", "-o", "input.txt"};
        Split.main(arg);
        String[] arg1 = {"-n 3", "-o yes", "input.txt"};
        Split.main(arg1);
        String[] arg2 = {"-n 6", "-o -", "input.txt"};
        Split.main(arg2);
        String[] arg3 = {"-n 7", "input.txt"};
        Split.main(arg3);
        //assertEquals();
    }

}