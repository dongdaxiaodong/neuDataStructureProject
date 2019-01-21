package com.bladejava.controller;
/**
 * @manageControl 该类是管理与停车场相关路由的类,包含基本的增删改查
 * */
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.bladejava.config.systemConfig;
import com.bladejava.service.algorithm.hamiltonian;
import com.bladejava.service.algorithm.myShortestPathalgorithm;
import com.bladejava.service.definedDataStructure.myLinkedList;
import com.bladejava.service.projectDataStructure.car;
import com.bladejava.service.projectDataStructure.information;
import com.bladejava.service.projectDataStructure.sceneNode;
import com.bladejava.service.projectDataStructure.scenePath;
import io.github.biezhi.anima.Anima;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("sight")
public class sightControl {


    /*注入依赖，将内存中的sceneGraphSys注入进去*/
    @Inject
    private systemConfig sceneGraphSys;

    /* 表明返回值是json格式 */
    @JSON
    @GetRoute("allNames")
    public String allNames(){
        sceneGraphSys.upload();
        myLinkedList<String> namesList=sceneGraphSys.mySceneGraph.getSceneNodeNameList();

        String[] resultArray=new String[namesList.actualLength];
        for(int i=0;i<namesList.actualLength;i+=1){
            resultArray[i]=namesList.get(i);
        }
        return com.alibaba.fastjson.JSON.toJSONString(resultArray);
    }

    @JSON
    @GetRoute("allCars")
    public String allCars(){
        List<car> allCars=Anima.select().from(car.class).all();
        return com.alibaba.fastjson.JSON.toJSONString(allCars);
    }

    @JSON
    @GetRoute("all")
    public String getAllSights(){
        sceneGraphSys.upload();
        myLinkedList<scenePath> myPathList=sceneGraphSys.mySceneGraph.getScenePathmyLinkedList();
        ArrayList<scenePath> returnPathList=new ArrayList<>();

        for(int i=0;i<myPathList.actualLength;i+=1){
            returnPathList.add(myPathList.get(i));
        }
        return com.alibaba.fastjson.JSON.toJSONString(returnPathList);
    }

    @JSON
    @GetRoute("hami")
    public String hami(Request request){
        String start=request.query("start","null");
        return com.alibaba.fastjson.JSON.toJSONString(hamiltonian.hamiPath(start).getLast());
    }

    @JSON
    @GetRoute("findSight")
    public String findSight(){
        sceneGraphSys.upload();
        myLinkedList<sceneNode> findSightList=sceneGraphSys.mySceneGraph.getSceneNodemyLinkedList();
        ArrayList<sceneNode> findSightArray=new ArrayList<>();
        for(int i=0;i<findSightList.actualLength;i+=1){
            findSightArray.add(findSightList.get(i));
        }
        return com.alibaba.fastjson.JSON.toJSONString(findSightArray);
    }

    @JSON
    @GetRoute("getTips")
    public String getTips(){
        List<information> tips=Anima.select().from(information.class).all();
        return com.alibaba.fastjson.JSON.toJSONString(tips);
    }

    @JSON
    @GetRoute("shortestPath")
    public String shortestPath(Request request){
        String start=request.query("start","no");
        String end=request.query("end","no");
        String shortestLength=myShortestPathalgorithm.ShortestPath(sceneGraphSys.mySceneGraph,start,end);
        return shortestLength;
    }

    @JSON
    @GetRoute("deletepath")
    public String deletepath(Request request){
        String startpath=request.query("startpath","null");
        String endpath=request.query("endpath","null");
        int check=-1;
        try {
            int result=Anima.delete().from(scenePath.class).where("start",startpath).where("end",endpath).execute();
            int result2=Anima.delete().from(scenePath.class).where("start",endpath).where("end",startpath).execute();
            check=1;
            List<car>theCar=Anima.select().from(car.class).filter(car->car.getStatus().equals("3")).collect(Collectors.toList());

        }
        catch (Exception e){
            check=0;
        }
        return check+"";
    }
    @JSON
    @GetRoute("allPath")
    public String allPath(Request request){
        List<scenePath> scenePaths= Anima.select().from(scenePath.class).all();
        return com.alibaba.fastjson.JSON.toJSONString((ArrayList<scenePath>)scenePaths);
    }

    @JSON
    @GetRoute("outcar")
    public String outcar(Request request){
        String time=request.query("time","null");
        String name=request.query("name","null");
        try {
            int result=Anima.update().from(car.class).set("status","2").where("carid",name).execute();
            int result2=Anima.update().from(car.class).set("end",time).where("carid",name).execute();
            List<car> cars= Anima.select().from(car.class).filter(car->car.getStatus().equals("3")).collect(Collectors.toList());
            if(cars.size()>0){
                car this_car=cars.get(0);
                Anima.update().from(car.class).set("status","1").where("carid",this_car.getCarNumber()).execute();
            }
        }
        catch (Exception  e){
            System.out.println(e);
        }
        return "ok";

    }

    @JSON
    @GetRoute("addcar")
    public String addCar(Request request){
        int id=(int)(Math.random()*10000);
        String carid=request.query("carnum","null");
        String status=request.query("status","null");
        String start=request.query("start","null");
        String end=request.query("endTime","null");
        int symbol=-1;
        try {
            Anima.save(new car(id,carid,status,start,end));
            symbol=1;
        }
        catch (Exception  e){
            symbol=2;
        }
        return symbol+"";
    }
}
