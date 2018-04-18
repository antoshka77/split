import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RealizationSplitTest {

    private static String content(String file) throws IOException {
        Scanner fileTemp = new Scanner(new FileReader(file));
        StringBuilder result = new StringBuilder("");
        while (fileTemp.hasNext()){
            result.append(fileTemp.nextLine());
            if (fileTemp.hasNext())
                result.append("\n");
        }
        fileTemp.close();
        return result.toString();
    }


    @Test
    void funL() throws IOException {
        String[] arg = {"-d", "-l 10", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yes1.txt"), content("funLoutputs/l1.txt"));
        assertEquals(content("yes2.txt"), content("funLoutputs/l2.txt"));
        assertEquals(content("yes3.txt"), content("funLoutputs/l3.txt"));
        assertEquals(content("yes4.txt"), content("funLoutputs/l4.txt"));
    }

    @Test
    void funC() throws IOException {
        String[] arg = {"-d", "-c 350", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yes1.txt"), content("funLoutputs/c1.txt"));
        assertEquals(content("yes2.txt"), content("funLoutputs/c2.txt"));
        assertEquals(content("yes3.txt"), content("funLoutputs/c3.txt"));
        assertEquals(content("yes4.txt"), content("funLoutputs/c4.txt"));
    }

    @Test
    void funN() throws IOException {
        String[] arg = {"-d", "-n 4", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yes1.txt"), content("funLoutputs/l1.txt"));
        assertEquals(content("yes2.txt"), content("funLoutputs/l2.txt"));
        assertEquals(content("yes3.txt"), content("funLoutputs/l3.txt"));
        assertEquals(content("yes4.txt"), content("funLoutputs/l4.txt"));
    }

    @Test
    void renameL() throws IOException {
        String[] arg = {"-l 10", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yesaa.txt"), content("funLoutputs/l1.txt"));
        assertEquals(content("yesab.txt"), content("funLoutputs/l2.txt"));
        assertEquals(content("yesac.txt"), content("funLoutputs/l3.txt"));
        assertEquals(content("yesad.txt"), content("funLoutputs/l4.txt"));
    }

    @Test
    void renameC() throws IOException {
        String[] arg = {"-c 350", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yesaa.txt"), content("funLoutputs/c1.txt"));
        assertEquals(content("yesab.txt"), content("funLoutputs/c2.txt"));
        assertEquals(content("yesac.txt"), content("funLoutputs/c3.txt"));
        assertEquals(content("yesad.txt"), content("funLoutputs/c4.txt"));
    }

    @Test
    void renameN() throws IOException {
        String[] arg = {"-l 4", "-o yes", "input/input.txt"};
        Split.main(arg);
        assertEquals(content("yesaa.txt"), content("funLoutputs/l1.txt"));
        assertEquals(content("yesab.txt"), content("funLoutputs/l2.txt"));
        assertEquals(content("yesac.txt"), content("funLoutputs/l3.txt"));
        assertEquals(content("yesad.txt"), content("funLoutputs/l4.txt"));
    }

}