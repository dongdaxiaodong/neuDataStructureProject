package com.bladejava.service.definedDataStructure;

import com.bladejava.service.projectDataStructure.auto;

/**
 myQueue类: 使用java的链式结构实现的queue数据结构
 myQueue基本功能:pop,size,peek,poll,get,set,contains,
*/
public class myQueue {
    private auto font;
    private auto rear;
    private int currentSize;

    public myQueue(){
        this.font=null;
        this.rear=null;
        this.currentSize=0;
    }

    public void enQueue(auto obj){
        if(this.currentSize==0){
            font=obj;
            rear=obj;

        }
        else {
            rear.setNext(obj);
        }
        this.currentSize+=1;
    }

    public void deQueue(){
        if(this.currentSize>=1){
            this.font=this.font.getNext();
            this.currentSize-=1;
        }
    }

    public auto getFont() {
        return font;
    }

    public void setFont(auto font) {
        this.font = font;
    }

    public auto getRear() {
        return rear;
    }

    public void setRear(auto rear) {
        this.rear = rear;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public boolean isEmpty(){
        return this.currentSize==0;
    }
}
