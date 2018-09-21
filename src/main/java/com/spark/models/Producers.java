package com.spark.models;

import java.util.UUID;

public class Producers {
    public String producerId;
    public String name;
    public String year;

    public Producers(String producer, String movieYear) {
        producerId = UUID.randomUUID().toString();
        name = producer;
        year = movieYear;
    }

    public String getName() {
      return name;
    }

    public String getYear() {
      return year;
    }
}
