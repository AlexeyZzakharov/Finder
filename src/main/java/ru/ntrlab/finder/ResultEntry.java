package ru.ntrlab.finder;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntry implements Comparable<ResultEntry> {
    private int count;
    private String word;

    @Override
    public String toString() {
        return String.format("Word: %s;   Count: %d;", word, count);
    }

    @Override
    public int compareTo(ResultEntry o) {
        return  this.getCount() - o.getCount();
    }
}
