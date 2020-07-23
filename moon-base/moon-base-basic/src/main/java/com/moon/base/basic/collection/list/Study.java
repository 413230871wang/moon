package com.moon.base.basic.collection.list;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/22 12:11 下午
 */
public class Study {
    private String name;
    private String score;

    public Study(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
