package com.bladejava.service.projectDataStructure;

import com.bladejava.service.definedDataStructure.myLinkedList;
import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

import java.util.HashMap;

/**
* sceneNode:景点类
* 其中包含了一个景点所有的信息
*/
@Table(name="node")
public class sceneNode extends Model{
    @Column(name="name")
    private String sceneName;

    /* hashMap中Key为邻接的景点的名称,Value为相应的距离 */
    @Column(name="des")
    private String description;

    @Column(name="popu")
    private int popularity;
    @Column(name="leisure")
    private boolean hasLeisure;

    @Column(name="toilet")
    private boolean hasToilet;

    @Column(name="turn")
    private int turnstiles;

    private myLinkedList<sceneNode> nearbyNodes;

    public sceneNode(String name,String description,int popularity,boolean hasLeisure, boolean hasToilet,int turnstiles){
        this.sceneName=name;
        this.description=description;
        this.popularity=popularity;
        this.hasLeisure=hasLeisure;
        this.hasToilet=hasToilet;
        this.turnstiles=turnstiles;
    }






    public int getTurnstiles() {
        return turnstiles;
    }

    public void setTurnstiles(int turnstiles) {
        this.turnstiles = turnstiles;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean getHasLeisure() {
        return hasLeisure;
    }

    public void setHasLeisure(boolean hasLeisure) {
        this.hasLeisure = hasLeisure;
    }

    public boolean getHasToilet() {
        return hasToilet;
    }

    public void setHasToilet(boolean hasToilet) {
        this.hasToilet = hasToilet;
    }
}
