package com.spark.models;

import java.util.UUID;

public class Producers {
    public String producerId;
    public String name;

    public Producers(String studio) {
        producerId = UUID.randomUUID().toString();
        name = studio;
    }
}
