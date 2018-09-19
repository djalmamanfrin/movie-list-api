package com.spark.utils.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Class CsvFileReader
 * Create a data transfer object class through csv file
 */
public class CsvFileReader {
    private List<MovieListDto> moviesList;

    public CsvFileReader() {
        run();
    }

    private void run() {
        try {
            String path = new File("movielist.csv").getAbsolutePath();
            FileReader reader = new FileReader(path);
            moviesList = new CsvToBeanBuilder(reader)
                    .withSeparator(';')
                    .withType(MovieListDto.class)
                    .build()
                    .parse();
        } catch (Exception e) {
              e.printStackTrace();
        }
    }

    public List<MovieListDto> getMovies() {
        moviesList.remove(0);
        return moviesList;
    }
}
