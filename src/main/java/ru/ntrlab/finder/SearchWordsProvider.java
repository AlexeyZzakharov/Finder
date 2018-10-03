package ru.ntrlab.finder;

import ru.ntrlab.finder.utils.Options;

import java.util.Arrays;
import java.util.List;

public class SearchWordsProvider {
    private final String pattern = "\\s*(\\s|,|!|\\.|:|-|\\w)\\s*";

    public List<String> getWords(Options options) throws Exception{

        boolean fileSpecified = options.getPath() != null;
        boolean wordsSpecified = options.getWords() != null && options.getWords().size() > 0;

        if (fileSpecified && wordsSpecified){
            System.out.println("Both path & words  are specified, so file path will be ignored");
        }

        if (wordsSpecified){
            return options.getWords();
        }
        else if(fileSpecified){
            return getWordsFromFile(options.getPath());
        }
        throw new Exception("Incorrect input args. Unable to proceed");
    }

    private List<String> getWordsFromFile(String path) throws Exception{
        WordsFileReader fileReader = new WordsFileReader();
        String fileText = fileReader.getFileText(path);
        String[] words = fileText.split(pattern);

        List<String> wordsFile = Arrays.asList(words);
        return wordsFile;
    }
}
