package com.spark.services.yearsWithWinners;

public class YearsWinnersDto {
    private String year;
    private Integer winnerCount;

    public YearsWinnersDto(String year, Integer winnerCount) {
        this.year = year;
        this.winnerCount = winnerCount;
    }
}
