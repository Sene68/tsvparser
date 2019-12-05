package com.tsvparser.univocity;

import com.univocity.parsers.tsv.*;

import java.io.*;
import java.util.List;

public class SampleTsvSelectionColumn {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        //column selection
        //settings.selectIndexes(0,2,5);
        settings.selectFields("A1","E1","F1");
        settings.setHeaderExtractionEnabled(true);

        // creates a TSV parser
        TsvParser parser = new TsvParser(settings);

        // parses all rows in one go.
        List<String[]> allRows = parser.parseAll(getReader("/sample2.tsv"));

        for (String[] strings : allRows) {
            for (String s : strings) {
                System.out.println(s);
            }
        }
    }

    public static Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(SampleTsvSelectionColumn.class.getResourceAsStream(relativePath), "UTF-8");
            //return new InputStreamReader(new FileInputStream(new File(relativePath)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unable to read input", e);
        }
    }
}
