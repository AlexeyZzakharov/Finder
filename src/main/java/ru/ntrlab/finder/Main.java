package ru.ntrlab.finder;

import ru.ntrlab.finder.utils.CmdOptionsParser;
import ru.ntrlab.finder.utils.Options;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            Options inputOptions = CmdOptionsParser.getParseOption(args);
            SearchWordsProvider wordsProvider = new SearchWordsProvider();
            List<String> searchWords = wordsProvider.getWords(inputOptions);

            ContentDownloader contentDownloader = new ContentDownloader();

            String content = contentDownloader.getContent();

            Finder finder = new Finder(searchWords);

            System.out.println("Words for searching:");
            searchWords.stream().forEach(System.out::println);

            System.out.println("\nResult entries:");
            finder.getEntrances(content)
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);
        }
        catch (Exception ex){
            System.out.printf("Something went wrong. Application will be stopped. Ex: %s", ex.toString());
        }
    }
}
