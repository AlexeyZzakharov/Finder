package ru.ntrlab.finder;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class Finder {
    private final List<String> searchWords;

    public List<ResultEntry> getEntrances(String content) {

        long count;
        List<ResultEntry> list = new ArrayList<>();

        List<String> contentWords = getContentWords(content);

        for (int i = 0; i < searchWords.size(); i++) {
            count = contentWords.stream()
                    .filter(Objects::nonNull)
                    .filter(searchWords.get(i)::equalsIgnoreCase)
                    .count();
            list.add(new ResultEntry((int) count, searchWords.get(i)));
        }
        return list;
    }

    private List<String> getContentWords(String content) {
        String[] words = content.split("\\s*(\\s|,|!|\\.|:|-|\\w)\\s*");
        return Arrays.asList(words);
    }
}
