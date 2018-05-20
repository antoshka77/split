import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RealizationSplitTest {

    private static String inString(String file) throws IOException {
        Scanner myFile = new Scanner(new FileReader(file));
        StringBuilder result = new StringBuilder("");
        while (myFile.hasNext()){
            result.append(myFile.nextLine());
            if (myFile.hasNext())
                result.append("\n");
        }
        myFile.close();
        return result.toString();
    }

    @Test
    void funL() throws IOException {
        RealizationSplit.funL("input/input.txt", 10, "yes", Filename.Digit);
        assertEquals(inString("yes1.txt"), inString("outputFiles/l1.txt"));
        assertEquals(inString("yes2.txt"), inString("outputFiles/l2.txt"));
        assertEquals(inString("yes3.txt"), inString("outputFiles/l3.txt"));
        assertEquals(inString("yes4.txt"), inString("outputFiles/l4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();

    }

    @Test
    void funC() throws IOException {
        RealizationSplit.funC("input/input.txt", 350, "yes", Filename.Digit);
        assertEquals(inString("yes1.txt"), inString("outputFiles/c1.txt"));
        assertEquals(inString("yes2.txt"), inString("outputFiles/c2.txt"));
        assertEquals(inString("yes3.txt"), inString("outputFiles/c3.txt"));
        assertEquals(inString("yes4.txt"), inString("outputFiles/c4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();
    }

    @Test
    void funN() throws IOException {
        RealizationSplit.funN("input/input.txt", 4, "yes", Filename.Digit);
        assertEquals(inString("yes1.txt"), inString("outputFiles/l1.txt"));
        assertEquals(inString("yes2.txt"), inString("outputFiles/l2.txt"));
        assertEquals(inString("yes3.txt"), inString("outputFiles/l3.txt"));
        assertEquals(inString("yes4.txt"), inString("outputFiles/l4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();
    }

    @Test
    void funLLetter() throws IOException {
        RealizationSplit.funL("input/input.txt", 10, "yes", Filename.Letter);
        assertEquals(inString("yesa.txt"), inString("outputFiles/l1.txt"));
        assertEquals(inString("yesb.txt"), inString("outputFiles/l2.txt"));
        assertEquals(inString("yesc.txt"), inString("outputFiles/l3.txt"));
        assertEquals(inString("yesd.txt"), inString("outputFiles/l4.txt"));
        new File("yesa.txt").delete();
        new File("yesb.txt").delete();
        new File("yesc.txt").delete();
        new File("yesd.txt").delete();

    }

    @Test
    void funCLetter() throws IOException {
        RealizationSplit.funC("input/input.txt", 350, "yes", Filename.Letter);
        assertEquals(inString("yesa.txt"), inString("outputFiles/c1.txt"));
        assertEquals(inString("yesb.txt"), inString("outputFiles/c2.txt"));
        assertEquals(inString("yesc.txt"), inString("outputFiles/c3.txt"));
        assertEquals(inString("yesd.txt"), inString("outputFiles/c4.txt"));
        new File("yesa.txt").delete();
        new File("yesb.txt").delete();
        new File("yesc.txt").delete();
        new File("yesd.txt").delete();
    }

    @Test
    void funNLetter() throws IOException {
        RealizationSplit.funN("input/input.txt", 4, "yes", Filename.Letter);
        assertEquals(inString("yesa.txt"), inString("outputFiles/l1.txt"));
        assertEquals(inString("yesb.txt"), inString("outputFiles/l2.txt"));
        assertEquals(inString("yesc.txt"), inString("outputFiles/l3.txt"));
        assertEquals(inString("yesd.txt"), inString("outputFiles/l4.txt"));
        new File("yesa.txt").delete();
        new File("yesb.txt").delete();
        new File("yesc.txt").delete();
        new File("yesd.txt").delete();
    }

}