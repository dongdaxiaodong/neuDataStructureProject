package com.bladejava.service.projectDataStructure;


/**
 * @auto 用于停车场管理系统的基本类，将由自己实现的myQueue封装
 * */
public class auto {
    private String name;
    private int id;
    private auto next;

    public auto(String name,int id,auto next){
        this.name=name;
        this.id=id;
        this.next=next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public auto getNext() {
        return next;
    }

    public void setNext(auto next) {
        this.next = next;
    }
}
