package com.spark.utils.csv;

// import java.util.Scanner;

public class CsvFileReader {
  
  public static void run() {
    FileReader reader = new FileReader("movielist.csv");
    List<MovieListDto> beans = new CsvToBeanBuilder(reader);
    beans.withType(MovieListDto.class);
    beans.build();
    beans.parse();
  }

}
