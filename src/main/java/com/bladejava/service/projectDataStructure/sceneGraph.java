package com.bladejava.service.projectDataStructure;

/**
 * @sceneGraph 景点图类，是该项目最重要的数据结构
 * @myLinkedList<sceneNode> 存放所有景点的链表(自己实现的数据结构)
 * @myLinkedList<String> 存放所有景点的名称
 * @myLinkedList<scenePath> 存放所有路径
 * @int[][]sceneNodeMatrix 存放邻接矩阵
 **/
import com.bladejava.service.definedDataStructure.myLinkedList;
public class sceneGraph {
    private myLinkedList<sceneNode> sceneNodemyLinkedList;
    private myLinkedList<String> sceneNodeNameList;
    private myLinkedList<scenePath> scenePathmyLinkedList;
    /* sceneNodeMatrix是邻接矩阵,和sceneNodeNameList一起服务于第一问*/
    private int[][] sceneNodeMatrix;

    /** 构造函数 */
    public sceneGraph(myLinkedList<sceneNode> sceneNodemyLinkedList,myLinkedList<scenePath> scenePathmyLinkedList){
        this.sceneNodemyLinkedList=sceneNodemyLinkedList;
        this.scenePathmyLinkedList=scenePathmyLinkedList;
        this.initialSceneNodeNameList();
    }

    /*初始化所有景点的名称*/
    private void initialSceneNodeNameList(){
        this.sceneNodeNameList=new myLinkedList<>();
        for(int i=0;i<this.sceneNodemyLinkedList.actualLength;i+=1){
            this.sceneNodeNameList.add(sceneNodemyLinkedList.get(i).getSceneName());
        }
        System.out.println(this.sceneNodeNameList.actualLength+"ooook");
    }



    public myLinkedList<sceneNode> getSceneNodemyLinkedList() {
        return sceneNodemyLinkedList;
    }

    public void setSceneNodemyLinkedList(myLinkedList<sceneNode> sceneNodemyLinkedList) {
        this.sceneNodemyLinkedList = sceneNodemyLinkedList;
    }

    public myLinkedList<String> getSceneNodeNameList() {
        return sceneNodeNameList;
    }

    public void setSceneNodeNameList(myLinkedList<String> sceneNodeNameList) {
        this.sceneNodeNameList = sceneNodeNameList;
    }

    public myLinkedList<scenePath> getScenePathmyLinkedList() {
        return scenePathmyLinkedList;
    }

    public void setScenePathmyLinkedList(myLinkedList<scenePath> scenePathmyLinkedList) {
        this.scenePathmyLinkedList = scenePathmyLinkedList;
    }

    public int[][] getSceneNodeMatrix() {
        return sceneNodeMatrix;
    }

    public void setSceneNodeMatrix(int[][] sceneNodeMatrix) {
        this.sceneNodeMatrix = sceneNodeMatrix;
    }
}
