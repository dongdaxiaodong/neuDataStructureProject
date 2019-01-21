package com.bladejava.service.algorithm;

import com.bladejava.service.projectDataStructure.scenePath;
import io.github.biezhi.anima.Anima;
import java.util.*;
import java.util.stream.Collectors;
public class hamiltonian {


/**
  该算法是解决哈密尔顿回路的算法,为本人原创
  该算法大致思想是通过广度优先算法进行迭代，然后求出所有解法，最终对解法进行排序
  算法复杂度和业界普遍算法复杂度类似
  @method:求从一个景点进入并且每个景点只走一次的算法
  @param :String start为该入口景点的名称
  返回值: LinkedList<LinkedList<String>> allRightPaths
  allRightPaths的size()为有多少条线路，allRightPaths.get(0)表示第一条成功线路
*/
    public static LinkedList<LinkedList<String>> hamiPath(String start){
        /* Anima.select()从数据库中取出所有的路径*/
        /* scenePath包含属性 startNode(String),endNode(String),weightValue(int)*/
        List<scenePath> allPaths=Anima.select().from(scenePath.class).all();
        List<String> startNames=allPaths.stream().
                map(path->path.getStartNode()).collect(Collectors.toList());
        List<String> endNames=allPaths.stream().
                map(path->path.getEndNode()).collect(Collectors.toList());
        startNames.addAll(endNames);
        /* nameList中包含所有景点的名称 */
        List<String> nameList=startNames.stream().
                distinct().
                collect(Collectors.toList());
        /* 该算法需要两个list,runningList中包含还需要继续深度遍历的list*/
        /* finishedList包含结束遍历并且经过所有景点1遍的路径*/
        LinkedList<LinkedList<String>> runningList=new LinkedList<>();
        LinkedList<LinkedList<String>> finishList=new LinkedList<>();
        LinkedList<LinkedList<String>> allList=new LinkedList<>();
        /*装载起始点*/
        LinkedList<String> startList=new LinkedList<>();
        startList.add(start);
        runningList.add(startList);
        while (runningList.size()>0){
            /*获取第一个*/
            LinkedList<String> nowList=runningList.poll();
            boolean finish=true;
            /*获取最后一个景点(这就相当于一个路径中的尾巴)*/
            String endNode=nowList.getLast();
            List<scenePath> containsList=allPaths.stream().
                    filter(path->{
                        String bothPath=path.getStartNode()+" "+path.getEndNode();
                        return bothPath.indexOf(endNode)>=0;
                    }).collect(Collectors.toList());

            /*对containsList进行迭代，然后逻辑判断是否应该加入runninngQueue,是广度优先算法的基本实现*/
            for(int i=0;i<containsList.size();i+=1){
                String bothStr=containsList.get(i).getStartNode()+" "+containsList.get(i).getEndNode();
                boolean canAdd=true;
                for(int k=0;k<(nowList.size()-1);k+=1){
                    if(bothStr.indexOf(nowList.get(k))>=0){

                        canAdd=false;
                        break;
                    }
                }
                if(canAdd){
                    String[] bothArray=bothStr.split(" ");
                    String addedStr=(bothArray[0].equals(endNode))?bothArray[1]:bothArray[0];
                    LinkedList<String> newList=(LinkedList<String>) nowList.clone();
                    newList.add(addedStr);
                    runningList.add(newList);
                }
                else {

                    if(nowList.size()==nameList.size()){
                        if(finish){
                            finishList.add(nowList);
                            finish=false;
                        }
                    }
                    else {
                        allList.add(nowList);
                    }
                }
            }
        }
        return (finishList.size()>0)?finishList:allList;
    }
}
