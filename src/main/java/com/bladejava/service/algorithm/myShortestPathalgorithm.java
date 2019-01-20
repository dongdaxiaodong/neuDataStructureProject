package com.bladejava.service.algorithm;

import com.bladejava.service.definedDataStructure.myLinkedList;
import com.bladejava.service.projectDataStructure.sceneGraph;
import com.bladejava.service.definedDataStructure.myQueue;
import com.bladejava.service.projectDataStructure.scenePath;
import java.util.HashMap;
import java.util.LinkedList;

/*
* myShortestPathalgorithm类:计算最短路径和值
*/
public class myShortestPathalgorithm {

    public static String ShortestPath(sceneGraph graph,String startNode,String endNode){
        myLinkedList<String> nameList=graph.getSceneNodeNameList();
        myLinkedList<scenePath> scenePathList=graph.getScenePathmyLinkedList();
        HashMap<String,Integer> pathMap=myShortestPathalgorithm.miniMap(nameList);
        HashMap<String,String> routeMap=myShortestPathalgorithm.pathMap(nameList);
//        for(int i=0;i<pathMap.keySet().toArray().length;i+=1){
//            System.out.println(pathMap.keySet().toArray()[i]);
//        }
        LinkedList<String> runningQueue=new LinkedList<>();
        myLinkedList<String> usedList=new myLinkedList<>();
        runningQueue.add(startNode);
        while (runningQueue.size()>0){
//          把第一个node的名字拿出来
            String nowNodeName=runningQueue.poll();
            usedList.add(nowNodeName);
//            然后遍历
            for(int i=0;i<scenePathList.actualLength;i+=1){
                scenePath traversedPath=scenePathList.get(i);
                String startPath=traversedPath.getStartNode();
                String endPath=traversedPath.getEndNode();
                int weight=traversedPath.getWeigthValue();
                if(startPath.equals(nowNodeName)){
                    if(!usedList.contains(endPath)){
                        int oldValue=pathMap.get(endPath);
                        if(oldValue==0){
                            runningQueue.add(endPath);
                            pathMap.put(endPath,pathMap.get(nowNodeName)+weight);
                            routeMap.put(endPath,routeMap.get(nowNodeName)+" "+routeMap.get(endPath));
                        }
                        else {
                            if(weight+pathMap.get(startPath)<oldValue){
                                pathMap.put(endPath,weight+pathMap.get(startPath));
                                routeMap.put(endPath,routeMap.get(startPath)+" "+endPath);
                            }
                        }
                    }
                }
            }
        }
        String route=routeMap.get(endNode);
        /* 这里应该注意到使用*进行切割,第一段为长度，第二段为route */
        return pathMap.get(endNode)+"*"+route;
    }

    /*辅助函数,返回一个hashMap用于统计最短路径*/
    public static HashMap<String,Integer> miniMap(myLinkedList<String> nameList){
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<nameList.actualLength;i+=1){
                map.put(nameList.get(i),0);
        }
        System.out.println(map.size());
        return map;
    }
    public static HashMap<String,String> pathMap(myLinkedList<String> nameList){
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<nameList.actualLength;i+=1){
            map.put(nameList.get(i),nameList.get(i));
        }
        return map;
    }
}
