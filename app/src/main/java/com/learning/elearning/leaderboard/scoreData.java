package com.learning.elearning.leaderboard;

public class scoreData {
    String name,image;
    long score;

    public scoreData() {
    }

    public scoreData(String name, String image, long score) {
        this.name = name;
        this.image = image;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
