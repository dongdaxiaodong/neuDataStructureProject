package com.bladejava.service.projectDataStructure;
/**
 * @information 该类为景区通知消息类
 * */

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

/**
 * 在数据库中定义表名:information
 */
@Table(name="information")
public class information extends Model {

    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="time")
    private String time;

    public information(int id,String title,String time){
        this.id=id;
        this.title=title;
        this.time=time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
