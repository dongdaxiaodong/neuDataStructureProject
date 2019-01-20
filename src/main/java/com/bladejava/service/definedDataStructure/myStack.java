package com.bladejava.service.definedDataStructure;

public class myStack<T> {
    private Object[] objStack;
    private int initialCapacity;
    private int maxCapacity;
    public int actualLength;

    public myStack(){
        this.initialCapacity=20;
        this.maxCapacity=this.initialCapacity;
        this.actualLength=0;
        this.objStack=new Object[this.initialCapacity];
    }

    public void push(T obj){
        this.objStack[this.actualLength]=obj;
        this.actualLength+=1;
    }

    public T pop(){
        T removedObj=(T)this.objStack[0];
        Object[] newObj=new Object[this.initialCapacity];
        for(int i=1;i<this.actualLength;i+=1){
            newObj[i-1]=this.objStack[i];
        }
        this.objStack=newObj;
        this.actualLength-=1;
        return removedObj;
    }

    public T peek(){
        T firstObj=(T)this.objStack[0];
        return firstObj;
    }
    public int size(){
        return this.actualLength;
    }
}
