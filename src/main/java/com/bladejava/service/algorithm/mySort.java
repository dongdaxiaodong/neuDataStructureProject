package com.bladejava.service.algorithm;

import com.bladejava.service.definedDataStructure.myLinkedList;
import com.bladejava.service.projectDataStructure.sceneNode;

/*
 mySort类:包含了冒泡排序和插入排序
 每种排序算法都支持按照欢迎度和岔路树进行排序
*/
public class mySort {

    public static myLinkedList<sceneNode> bubbleSort(myLinkedList<sceneNode> sceneNodemyLinkedList,String param){

        for(int i=sceneNodemyLinkedList.actualLength-1;i>0;i-=1){
            for(int k=0;k<i;k+=1){
                sceneNode fontSceneNode=sceneNodemyLinkedList.get(k);
                sceneNode backSceneNode=sceneNodemyLinkedList.get(k+1);
                if(param.equals("欢迎度")){
                    if(fontSceneNode.getPopularity()>=backSceneNode.getPopularity()){
                        sceneNodemyLinkedList.set(k,backSceneNode);
                        sceneNodemyLinkedList.set(k+1,fontSceneNode);
                    }
                }
                else {
                    if(fontSceneNode.getTurnstiles()>=backSceneNode.getTurnstiles()){
                        sceneNodemyLinkedList.set(k,backSceneNode);
                        sceneNodemyLinkedList.set(k+1,fontSceneNode);
                    }
                }
            }
        }
        return sceneNodemyLinkedList;
    }

    public static myLinkedList<sceneNode> insertSort(myLinkedList<sceneNode> sceneNodemyLinkedList,String param){
        myLinkedList<sceneNode> newSceneNodeList=new myLinkedList<>();
        for(int i=0;i<sceneNodemyLinkedList.actualLength;i+=1){
            sceneNode thisNode=sceneNodemyLinkedList.get(i);
            if(newSceneNodeList.actualLength==0){
                newSceneNodeList.add(sceneNodemyLinkedList.get(i));
            }
            else {
                for(int k=0;k<newSceneNodeList.actualLength;k+=1){
                    boolean insertSuccess=false;
                    if(param.equals("受欢迎度")){
                        if(thisNode.getPopularity()<newSceneNodeList.get(k).getPopularity()){
                            newSceneNodeList.add(k,thisNode);
                            insertSuccess=true;
                            break;
                        }
                    }
                    else {
                        if(thisNode.getTurnstiles()<newSceneNodeList.get(k).getTurnstiles()){
                            newSceneNodeList.add(k,thisNode);
                            insertSuccess=true;
                            break;
                        }
                    }
                    if(!insertSuccess){
                        newSceneNodeList.add(thisNode);
                    }
                }
            }
        }
        return newSceneNodeList;
    }
}
