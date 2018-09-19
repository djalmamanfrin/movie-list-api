package com.spark.models;

import java.util.UUID;

public class Studios {
    private String studioId;
    private String name;

    public Studios(String studio) {
        studioId = UUID.randomUUID().toString();
        name = studio;
    }
}
