package com.spark.serives.rangesOfAwards;

public class RangesOfAwardsDto {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    void setProducer(String producer) {
        this.producer = producer;
    }

    void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getInterval() {
        return interval;
    }

    void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }

    void setFollowingWin(Integer followingWin) {
        this.followingWin = followingWin;
    }
}
