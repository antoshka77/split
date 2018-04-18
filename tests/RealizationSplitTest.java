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
        RealizationSplit.funL("input/input.txt", 10, "yes");
        assertEquals(inString("yes1.txt"), inString("funLoutputs/l1.txt"));
        assertEquals(inString("yes2.txt"), inString("funLoutputs/l2.txt"));
        assertEquals(inString("yes3.txt"), inString("funLoutputs/l3.txt"));
        assertEquals(inString("yes4.txt"), inString("funLoutputs/l4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();

    }

    @Test
    void funC() throws IOException {
        RealizationSplit.funC("input/input.txt", 350, "yes");
        assertEquals(inString("yes1.txt"), inString("funLoutputs/c1.txt"));
        assertEquals(inString("yes2.txt"), inString("funLoutputs/c2.txt"));
        assertEquals(inString("yes3.txt"), inString("funLoutputs/c3.txt"));
        assertEquals(inString("yes4.txt"), inString("funLoutputs/c4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();
    }

    @Test
    void funN() throws IOException {
        RealizationSplit.funN("input/input.txt", 4, "yes");
        assertEquals(inString("yes1.txt"), inString("funLoutputs/l1.txt"));
        assertEquals(inString("yes2.txt"), inString("funLoutputs/l2.txt"));
        assertEquals(inString("yes3.txt"), inString("funLoutputs/l3.txt"));
        assertEquals(inString("yes4.txt"), inString("funLoutputs/l4.txt"));
        new File("yes1.txt").delete();
        new File("yes2.txt").delete();
        new File("yes3.txt").delete();
        new File("yes4.txt").delete();
    }

    @Test
    void renameL() throws IOException {
        RealizationSplit.renameL("input/input.txt", 10, "yes");
        assertEquals(inString("yesaa.txt"), inString("funLoutputs/l1.txt"));
        assertEquals(inString("yesab.txt"), inString("funLoutputs/l2.txt"));
        assertEquals(inString("yesac.txt"), inString("funLoutputs/l3.txt"));
        assertEquals(inString("yesad.txt"), inString("funLoutputs/l4.txt"));
        new File("yesaa.txt").delete();
        new File("yesab.txt").delete();
        new File("yesac.txt").delete();
        new File("yesad.txt").delete();
    }

    @Test
    void renameC() throws IOException {
        RealizationSplit.renameC("input/input.txt", 350, "yes");
        assertEquals(inString("yesaa.txt"), inString("funLoutputs/c1.txt"));
        assertEquals(inString("yesab.txt"), inString("funLoutputs/c2.txt"));
        assertEquals(inString("yesac.txt"), inString("funLoutputs/c3.txt"));
        assertEquals(inString("yesad.txt"), inString("funLoutputs/c4.txt"));
        new File("yesaa.txt").delete();
        new File("yesab.txt").delete();
        new File("yesac.txt").delete();
        new File("yesad.txt").delete();
    }

    @Test
    void renameN() throws IOException {
        RealizationSplit.renameN("input/input.txt", 4, "yes");
        assertEquals(inString("yesaa.txt"), inString("funLoutputs/l1.txt"));
        assertEquals(inString("yesab.txt"), inString("funLoutputs/l2.txt"));
        assertEquals(inString("yesac.txt"), inString("funLoutputs/l3.txt"));
        assertEquals(inString("yesad.txt"), inString("funLoutputs/l4.txt"));
        new File("yesaa.txt").delete();
        new File("yesab.txt").delete();
        new File("yesac.txt").delete();
        new File("yesad.txt").delete();
    }

}