package com.spark.services.winnersStudios;

public class WinnersStudiosTupleDto {
    private String studioName;
    private Integer winnerCount;

    public WinnersStudiosTupleDto(String studioName, Integer winnerCount) {
        this.studioName = studioName;
        this.winnerCount = winnerCount;
    }
}
