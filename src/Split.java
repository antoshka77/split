import org.kohsuke.args4j.*;

import java.io.*;

public class Split {

    @Option(name = "-o", metaVar = "ofile", required = true, usage = "Specifies the basename of output file")
    private String basicOutputName;

    @Option(name = "-d", required = true, usage = "How should I name the file")
    private String whatIsName;

    @Option(name = "-l", metaVar = "num", required = true, usage = "Indicates the size of the file in lines")
    private String sizeInLines;

    @Option(name = "-c", metaVar = "num", required = true, usage = "Indicates the size of the file in characters")
    private String sizeInChars;

    @Option(name = "-n", metaVar = "num", required = true, usage = "Indicates the number of files")
    private String countFiles;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
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
        }

        if ((sizeInLines != null && sizeInChars != null) || (sizeInLines != null && countFiles != null)
                || (countFiles != null && sizeInChars != null) || (inputFile == null)) {
            System.err.println("Incorrect argument format");
            parser.printUsage(System.err);
        } else {

            String ofile;
            if (basicOutputName == null) ofile = "x";
            else if (basicOutputName == "-") ofile = inputFile;
            else ofile = basicOutputName;

            if (whatIsName != null) {
                if (sizeInLines != null) RealizationSplit.funL(inputFile, sizeInLines, ofile);

                if (sizeInChars != null) RealizationSplit.funC(inputFile, sizeInChars, ofile);

                if (countFiles != null) RealizationSplit.funN(inputFile, countFiles, ofile);

                if ((sizeInChars == null) && (sizeInLines == null) && (countFiles == null))
                    RealizationSplit.funConst(inputFile, ofile);
            } else {
                if (sizeInLines != null) RealizationSplit.renameL(inputFile, sizeInLines, ofile);

                if (sizeInChars != null) RealizationSplit.renameC(inputFile, sizeInChars, ofile);

                if (countFiles != null) RealizationSplit.renameN(inputFile, countFiles, ofile);

                if ((sizeInChars == null) && (sizeInLines == null) && (countFiles == null))
                    RealizationSplit.renameConst(inputFile, ofile);
            }
        }
    }
}