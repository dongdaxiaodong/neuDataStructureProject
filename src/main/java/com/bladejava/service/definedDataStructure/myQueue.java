//package com.bladejava.service.definedDataStructure;
//
//import com.bladejava.service.projectDataStructure.car;
//
//import java.util.Queue;
//
///*
// myQueue类: 使用Array这一基本数据结构实现的的queue
// myQueue基本功能:pop,size,peek,poll,get,set,contains,
//*/
//public class myQueue {
//    private car font;
//    private car rear;
//    private int currentSize;
//
//    public myQueue(){
//        this.font=null;
//        this.rear=null;
//        this.currentSize=0;
//    }
//
//    public void enQueue(car obj){
//        if(this.currentSize==0){
//            font=obj;
//            rear=obj;
//
//        }
//        else {
//            rear.setNext(obj);
//        }
//        this.currentSize+=1;
//    }
//
//    public void deQueue(){
//        if(this.currentSize>=1){
//            this.font=this.font.getNext();
//            this.currentSize-=1;
//        }
//    }
//
//    public car getFont() {
//        return font;
//    }
//
//    public void setFont(car font) {
//        this.font = font;
//    }
//
//    public car getRear() {
//        return rear;
//    }
//
//    public void setRear(car rear) {
//        this.rear = rear;
//    }
//
//    public int getCurrentSize() {
//        return currentSize;
//    }
//
//    public void setCurrentSize(int currentSize) {
//        this.currentSize = currentSize;
//    }
//
//    public boolean isEmpty(){
//        return this.currentSize==0;
//    }
//}
