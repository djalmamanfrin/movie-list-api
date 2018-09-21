package com.spark.utils.csv;

import com.opencsv.bean.CsvBindByPosition;
import java.util.Arrays;
import java.util.List;

/**
 * Class MovieListDto
 * Responsible to parse csv data
 */
public class MovieListDto {
    private static final String COMMA_SEPARATOR = ",";
    private static final String AND_SEPARATOR = " and ?";

    @CsvBindByPosition(position = 0)
    private String year;

    @CsvBindByPosition(position = 1)
    private String title;

    @CsvBindByPosition(position = 2)
    private String studios;

    @CsvBindByPosition(position = 3)
    private String producers;

    @CsvBindByPosition(position = 4)
    private String winner;

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getStudios() {
        String allStudios = studios.replace(AND_SEPARATOR, COMMA_SEPARATOR);
        return Arrays.asList(allStudios.split(COMMA_SEPARATOR));
    }

    public List<String> getProducers() {
        String allProducers = producers.replaceAll(AND_SEPARATOR, COMMA_SEPARATOR);
        return Arrays.asList(allProducers.split(COMMA_SEPARATOR));
    }

    public Boolean getWinner() {
        return "yes".equals(winner);
    }
}
