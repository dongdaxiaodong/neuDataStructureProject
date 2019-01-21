package com.bladejava.service.definedDataStructure;

/**
1.使用最基本的数据结构Array和泛型实现LinkedList数据结构
2.实现后的myLinkedList数据结构将用于构造景区的邻接表
*/
import java.util.stream.Stream;
public class myLinkedList<T>{
    private Object[] myArray;
    private int initialCapacity;
    private int maxCapacity;
    public int actualLength;
    private int length;

    public myLinkedList(){
        this.initialCapacity=20;
        this.myArray=new Object[this.initialCapacity];
        this.actualLength=0;
        this.maxCapacity=this.initialCapacity;
        this.length=actualLength;
    }


    private void addCapacity(){
        Object[] oldArray=this.myArray;
        Object[] newArray=new Object[oldArray.length+this.initialCapacity];
        this.maxCapacity=oldArray.length+this.initialCapacity;
        for(int i=0;i<oldArray.length;i+=1){
            newArray[i]=oldArray[i];
        }
        this.maxCapacity+=this.initialCapacity;
        this.myArray=newArray;
    }

    /* 检测容量 */
    private boolean checkCapacity(){
        if(this.actualLength<this.maxCapacity){
            /*实际长度小于Max表明容量安全可以添加*/
            return true;
        }
        else {
            return false;
        }
    }

    public boolean add(T obj){
        if(!checkCapacity()){
            /* 如果myArray满了，需要扩容 */
            this.addCapacity();
            this.myArray[this.actualLength]=obj;
        }
        else {
            this.myArray[this.actualLength]=obj;
        }
        this.actualLength+=1;
        return true;
    }

    public void add(int index,T obj){
        if(!checkCapacity()){
            /* 如果myArray满了，需要扩容 */
            this.addCapacity();
            this.addBoth(index,obj);

        }
        else {
            this.addBoth(index,obj);
        }
        this.actualLength+=1;
    }


    private void addBoth(int index,Object obj){
        Object[] addedArray=new Object[maxCapacity];
        for(int i=0;i<this.actualLength+1;i+=1){
            if(i==index){
                addedArray[i]=obj;
            }
            else {
                if(i<index){
                    addedArray[i]=this.myArray[i];
                }
                else {
                    addedArray[i]=this.myArray[i-1];
                }
            }
        }
        this.myArray=addedArray;
    }

    public T remove(int index){
        T returnRemovedObj;
        if(index>=this.actualLength || index<0){
            returnRemovedObj= null;
        }
        else {
            returnRemovedObj=this.removeBoth(index);
        }
        return returnRemovedObj;
    }

    public boolean remove(Object obj){
        boolean canRemove=false;
        int canRemoveIndex=-1;
        for(int i=0;i<this.actualLength;i+=1){
            if(this.myArray[i].equals(obj)){
                canRemoveIndex=i;
                canRemove=true;
                break;
            }
        }
        if(canRemoveIndex>=0){
            this.removeBoth(canRemoveIndex);
        }
        return canRemove;
    }

    private T removeBoth(int canRemoveIndex){
        T removedObj=null;
        Object[] newObjectArray=new Object[maxCapacity];
        for(int i=0;i<this.myArray.length;i+=1){
            if(i<canRemoveIndex){

                newObjectArray[i]=this.myArray[i];
            }
            else if(i>canRemoveIndex) {
                newObjectArray[i-1]=this.myArray[i];
            }
            else {
                removedObj=(T)this.myArray[i];
            }
        }
        this.myArray=newObjectArray;
        this.actualLength-=1;
        return removedObj;
    }

    public int indexOf(Object obj){
        int index=-1;
        for(int i=0;i<this.actualLength;i+=1){
            if(this.myArray[i].equals(obj)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean contains(Object obj){
        boolean contain=false;
        for(int i=0;i<this.actualLength;i+=1){
            if(this.myArray[i].equals(obj)){
                contain=true;
                break;
            }
        }
        return contain;
    }

    public T get(int index){
        T obj;
        if(index<0 || index>=this.actualLength){
            obj=null;
        }
        else {
            obj=(T)this.myArray[index];
        }
        return obj;
    }

    public T set(int index,Object newObj){
        T oldObj=null;
        for(int i=0;i<this.actualLength;i+=1){
            if(index==i){
                oldObj=(T)this.myArray[i];
                this.myArray[i]=newObj;
                break;
            }
        }
        return oldObj;
    }

    public void toOutput(){
        Stream.of(this.myArray).forEach(
                obj->{
                    if(obj!=null){
                        System.out.println(obj);
                    }
                }
        );
    }
}