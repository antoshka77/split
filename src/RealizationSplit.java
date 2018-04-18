import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class RealizationSplit {

    static void funL(String file, int sizeInLines, String outputName) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(file));
        int count;
        if (list.size() % sizeInLines == 0) count = list.size() / sizeInLines;
        else count = list.size() / sizeInLines + 1;
        for (int i = 0; i < count; i++) {
            int postfix = i + 1;
            File littleFile = new File(outputName + postfix + ".txt");
            littleFile.createNewFile();
            FileWriter fw = new FileWriter(littleFile);
            for (int n = i * sizeInLines; n < (i + 1) * sizeInLines; n++) {
                fw.write(list.get(n) + "\n");
                if (n == list.size() - 1) break;
            }
            fw.close();
        }
    }

    static void funC(String file, int sizeInChars, String outputName) throws IOException {
        ArrayList<Character> chars = new ArrayList<>();
        FileReader reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
            chars.add((char) c);
        }
        int count;
        if (chars.size() % sizeInChars == 0) count = chars.size() / sizeInChars;
        else count = chars.size() / sizeInChars + 1;
        for (int i = 0; i < count; i++) {
            int postfix = i + 1;
            File littleFile = new File(outputName + postfix + ".txt");
            littleFile.createNewFile();
            FileWriter fw = new FileWriter(littleFile);
            for (int n = i * sizeInChars; n < (i + 1) * sizeInChars; n++) {
                fw.write(chars.get(n));
                if (n == chars.size() - 1) break;
            }
            fw.close();
        }
    }

    static void funN(String file, int countFiles, String outputName) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(file));
        int linesCount;
        if (list.size() % countFiles == 0) linesCount = list.size() / countFiles;
        else linesCount = list.size() / countFiles + 1;
        funL(file, linesCount, outputName);
    }

    static void renameL(String file, int sizeInLines, String outputName) throws IOException {
        funL(file, sizeInLines, outputName);
        rename(outputName);
    }

    static void renameC(String file, int sizeInChars, String outputName) throws IOException {
        funC(file, sizeInChars, outputName);
        rename(outputName);
    }

    static void renameN(String file, int countSize, String outputName) throws IOException {
        funN(file, countSize, outputName);
        rename(outputName);
    }

    static void rename(String outputName) {
        ArrayList<String> letterMove = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String s = new String();
            s += c;
            letterMove.add(s);
        }
        int count = 1;
        File littleFile = new File(outputName + count + ".txt");
        while (littleFile.exists()) {
            File renamedFile = new File(outputName + letterMove.get((count - 1) / 26)
                    + letterMove.get((count - 1) % 26) + ".txt");
            if (littleFile.renameTo(renamedFile)) {
                count++;
                littleFile = new File(outputName + count + ".txt");
            }
        }
    }
}
