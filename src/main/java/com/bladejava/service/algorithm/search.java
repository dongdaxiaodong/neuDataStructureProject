package com.bladejava.service.algorithm;
import com.bladejava.service.projectDataStructure.sceneNode;
/*
* search类:其中包括了用于搜索的算法
*/
public class search {

    /*
    * @param sceneNode,String 参数一个是待匹配的sceneNode,一个是用于匹配的String
    * */
    public static boolean containsValue(sceneNode sceneNode,String str){
        String allDescription=sceneNode.getSceneName().concat(sceneNode.getDescription());
        if(allDescription.contains(str)){
            return true;
        }
        else {
            return false;
        }
    }
}
