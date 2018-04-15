import java.io.*;
import java.util.*;

class RealizationSplit {

    static void funL(String file, String sizeInLines, String outputName) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader(file));
        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        int linesCount = Integer.parseInt(sizeInLines);
        int count;
        if (list.size() % linesCount == 0) count = list.size() / linesCount;
        else count = list.size() / linesCount + 1;
        for (int i = 0; i < count; i++) {
            int postfix = i + 1;
            File littleFile = new File(outputName + postfix + ".txt");
            littleFile.createNewFile();
            FileWriter fw = new FileWriter(littleFile);
            for (int n = i * linesCount; n < (i + 1) * linesCount; n++) {
                fw.write(list.get(n));
            }
            fw.close();
        }
    }

    static void funC(String file, String sizeInChars, String outputName) throws IOException {
        ArrayList<Character> chars = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(file)));
            int c;
            while ((c = reader.read()) != -1) {
                chars.add((char) c);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        int charsCount = Integer.parseInt(sizeInChars);
        int count;
        if (chars.size() % charsCount == 0) count = chars.size() / charsCount;
        else count = chars.size() / charsCount + 1;
        for (int i = 0; i < count; i++) {
            int postfix = i + 1;
            File littleFile = new File(outputName + postfix + ".txt");
            littleFile.createNewFile();
            if (littleFile.createNewFile()) {
                FileWriter fw = new FileWriter(littleFile);
                for (int n = i * charsCount; n < (i + 1) * charsCount; n++) {
                    fw.write(chars.get(n));
                }
                fw.close();
            }
        }
    }

    static void funN(String file, String countFiles, String outputName) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader(file));
        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        int linesCount;
        if (list.size() % Integer.parseInt(countFiles) == 0) linesCount = list.size() / Integer.parseInt(countFiles);
        else linesCount = list.size() / Integer.parseInt(countFiles) + 1;
        funL(file, String.valueOf(linesCount), outputName);
    }

    static void funConst(String file, String outputName) throws IOException {
        int lines = 100;
        funL(file, String.valueOf(lines), outputName);
    }

    static void renameL(String file, String sizeInLines, String outputName) throws IOException {
        ArrayList<Character> letterMove = new ArrayList<>();
        for (int i = 0, j = 'a'; j <= 'z'; i++, j++) {
            letterMove.set(i, (char) j);
        }
        funL(file, sizeInLines, outputName);
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

    static void renameC(String file, String sizeInLines, String outputName) throws IOException {
        ArrayList<Character> letterMove = new ArrayList<>();
        for (int i = 0, j = 'a'; j <= 'z'; i++, j++) {
            letterMove.set(i, (char) j);
        }
        funC(file, sizeInLines, outputName);
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

    static void renameConst(String file, String outputName) throws IOException {
        ArrayList<Character> letterMove = new ArrayList<>();
        for (int i = 0, j = 'a'; j <= 'z'; i++, j++) {
            letterMove.set(i, (char) j);
        }
        funConst(file, outputName);
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

    static void renameN(String file, String sizeInLines, String outputName) throws IOException {
        ArrayList<Character> letterMove = new ArrayList<>();
        for (int i = 0, j = 'a'; j <= 'z'; i++, j++) {
            letterMove.set(i, (char) j);
        }
        funN(file, sizeInLines, outputName);
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
