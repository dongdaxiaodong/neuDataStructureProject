package com.bladejava.service.projectDataStructure;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
/**
 * @author 张奥东
 * @return scenePath类是有关景点间路径的类，包含id,startNode,endNode,weight等属性
* */


/**
 * @Table 用于在数据库中进行对应
 * */
@Table(name="path")
public class scenePath extends Model{

    @Column(name="id")
    private Integer id;

    @Column(name="weight")
    private int weigthValue;

    @Column(name="start")
    private String startNode;

    @Column(name="end")
    private String endNode;

    public scenePath(int weigthValue,String startNode,String endNode){
        this.weigthValue=weigthValue;
        this.startNode=startNode;
        this.endNode=endNode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWeigthValue() {
        return weigthValue;
    }

    public void setWeigthValue(int weigthValue) {
        this.weigthValue = weigthValue;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }
}
