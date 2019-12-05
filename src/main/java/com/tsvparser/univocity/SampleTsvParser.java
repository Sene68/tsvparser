package com.tsvparser.univocity;

import com.univocity.parsers.tsv.*;

import java.io.*;
import java.util.List;

public class SampleTsvParser {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");

        // creates a TSV parser
        TsvParser parser = new TsvParser(settings);

        // parses all rows in one go.
        List<String[]> allRows = parser.parseAll(getReader("/sample.tsv"));

        for (String[] strings : allRows) {
            for (String s : strings) {
                System.out.println(s);
            }
        }
    }

    public static Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(SampleTsvParser.class.getResourceAsStream(relativePath), "UTF-8");
            //return new InputStreamReader(new FileInputStream(new File(relativePath)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unable to read input", e);
        }
    }
}
