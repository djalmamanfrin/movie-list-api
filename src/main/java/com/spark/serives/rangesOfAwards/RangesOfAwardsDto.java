package com.spark.serives.rangesOfAwards;

public class RangesOfAwardsDto {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }

    public void setFollowingWin(Integer followingWin) {
        this.followingWin = followingWin;
    }
}
