package com.spark.utils.csv;

import com.spark.models.Studios;
import com.spark.models.Producers;

public class MovieListDto {

  @CsvBindByName(column = "year", required = true)
  private String year;

  @CsvBindByName(column = "title", required = true)
  private String title;

  @CsvBindByName(column = "studios", required = true)
  private String studios;

  @CsvBindByName(column = "producers", required = true)
  private String producers;

  @CsvBindByName(column = "winner", required = true)
  private Boolean winner;

  // fazer tbm o getProducers
  public List<Studios> getStudios() {
    //criar patten
    List<String> items = Arrays.asList(studios.split("pattern"));
  }
}
