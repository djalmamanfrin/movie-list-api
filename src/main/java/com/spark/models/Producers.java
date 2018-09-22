package com.spark.models;

public class Producers {
    public String name;
    public String year;

    public Producers(String producer, String movieYear) {
        name = producer.trim();
        year = movieYear.trim();
    }

    public String getName() {
      return name;
    }

    public Integer getYear() {
      return Integer.parseInt(year);
    }
}
