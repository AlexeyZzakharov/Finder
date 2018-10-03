package ru.ntrlab.finder.utils;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Options {
    private List<String> words;
    private String path;
}
