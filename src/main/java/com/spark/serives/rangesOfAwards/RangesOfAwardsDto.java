package com.spark.serives.rangesOfAwards;

public class RangesOfAwardsDto {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public RangesOfAwardsDto(String producer, Integer previousWin, Integer followingWin) {
        this.producer = producer;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
        this.interval = followingWin - previousWin;
    }
}
