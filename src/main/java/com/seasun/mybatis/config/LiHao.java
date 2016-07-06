package com.seasun.mybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "lihao")
@Component
public class LiHao {
    private String name;
    private int height;
    private String habits;
    private String love;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height + 100;
    }
    public void setHeight(int height) {
        this.height = height + 50;
    }
    public String getHabits() {
        return habits;
    }
    public void setHabits(String habits) {
        this.habits = habits;
    }
    public String getLove() {
        return love;
    }
    public void setLove(String love) {
        this.love = love;
    }
    
    
}
