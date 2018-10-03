package ru.ntrlab.finder;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@NoArgsConstructor
public class WordsFileReader {

    public String getFileText(String path) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine())!= null){
                sb.append(str);
                sb.append(" ");
            }
            return sb.toString();
        } catch (IOException ex) {
            System.out.printf("Error reading file. Exception: %s", ex.toString());
            throw new Exception("Unable to proceed work without correct file path");
        }
    }
}
