package ru.ntrlab.finder.utils;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;

public class CmdOptionsParser {

    public static org.apache.commons.cli.Options getOption() {
        org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();

        Option u = new Option("w", "word", true, "search word");
        u.setOptionalArg(false);
        u.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(u);

        Option f = new Option("p", "path", true, "path to the file");
        f.setOptionalArg(false);
        options.addOption(f);
        return options;
    }

    public static Options getParseOption(String[] args) {
        org.apache.commons.cli.Options option = getOption();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(option, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("utility-name", option);
            System.exit(1);
        }
        String[] words = cmd.getOptionValues("word");
        String path = cmd.getOptionValue("path");

        if(words==null && path==null){
            System.out.println("Введите пожалуйста слова -w, или путь к файлу -p, в котором указаны слова для поиска");
            System.exit(1);
        }

        return new Options(Arrays.asList(words), path);
    }
}
