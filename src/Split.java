import org.kohsuke.args4j.*;

import java.io.*;
import java.util.Objects;

public class Split {

    @Option(name = "-o", usage = "Specifies the basename of output file")
    private String basicOutputName;

    @Option(name = "-d", usage = "How should I name the file")
    private boolean whatIsName;

    @Option(name = "-l", usage = "Indicates the size of the file in lines", forbids = {"-c", "-n"})
    private int sizeInLines = -1;

    @Option(name = "-c", usage = "Indicates the size of the file in characters", forbids = {"-l", "-n"})
    private int sizeInChars = -1;

    @Option(name = "-n", usage = "Indicates the number of files", forbids = {"-l", "-c"})
    private int countFiles = -1;

    @Argument(required = true, usage = "Input file name")
    private String inputFile;


    public static void main(String[] args) throws IOException {
      new Split().launch(args);
    }

    private void launch(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar split.jar -d -l num -o basicOutputName inputFileName");
            System.err.println("java -jar split.jar -d -c num -o basicOutputName inputFileName");
            System.err.println("java -jar split.jar -d -n num -o basicOutputName inputFileName");
            parser.printUsage(System.err);
            return;
        }

        String ofile;
        if (basicOutputName == null) ofile = "x";
        else if (Objects.equals(basicOutputName, "-")) ofile = inputFile.split(".txt")[0];
        else ofile = basicOutputName;

        Filename filenameGenerator = whatIsName ? Filename.Digit : Filename.Letter;

        if (sizeInLines != -1) RealizationSplit.funL(inputFile, sizeInLines, ofile, filenameGenerator);

        if (sizeInChars != -1) RealizationSplit.funC(inputFile, sizeInChars, ofile, filenameGenerator);

        if (countFiles != -1) RealizationSplit.funN(inputFile, countFiles, ofile, filenameGenerator);

        if ((sizeInChars == -1) && (sizeInLines == -1) && (countFiles == -1))
            RealizationSplit.funL(inputFile, 100, ofile, filenameGenerator);
    }
}