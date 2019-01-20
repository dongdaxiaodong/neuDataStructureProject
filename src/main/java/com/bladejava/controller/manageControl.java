package com.bladejava.controller;


import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.bladejava.config.systemConfig;
import com.bladejava.service.projectDataStructure.information;
import com.bladejava.service.projectDataStructure.sceneNode;
import com.bladejava.service.projectDataStructure.scenePath;
import io.github.biezhi.anima.Anima;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("manage")
public class manageControl {

    @Inject
    private systemConfig sceneGraphSys;

    @JSON
    @GetRoute("saveTip")
    public String saveTip(Request request){
        String title=request.parameters().get("title").get(0);
        String date=request.parameters().get("date").get(0);
        try {
            int number=(int)(Math.random()*10000);
            Anima.save(new information(number,title,date));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "ok";
    }

    @JSON
    @GetRoute("addSight")
    public String allSight(Request request){
        int symbol=0;
        String name=request.query("name","no");
        String des=request.query("des","no");
        int popularity=Integer.parseInt(request.query("popularity","no"));
        boolean leisure=(request.query("leisure","no")).equals("1");
        boolean toilet=(request.query("toilet","no")).equals("1");
        int turn =Integer.parseInt(request.query("turn","no"));
        try {
            Anima.save(new sceneNode(name,des, popularity,leisure,toilet,turn));
            symbol=1;
        }
        catch (Exception e){
            symbol=2;
        }


    return symbol+"";
    }


    @JSON
    @GetRoute("deleteSight")
    public String deleteSight(Request request){
        String name=request.query("name","null");
        int symbol=-1;
        if(name.equals("null")){
            symbol=0;
        }
        return "ok";
    }

    @JSON
    @GetRoute("uploadPath")
    public String uploadPath(Request request){
        String symbol="0";
        String start=request.query("start","null");
        String end=request.query("end","null");
        String newweight=request.query("newWeight","null");
        String oldWeight=request.query("oldWeight","null");
        System.out.println(start);
        System.out.println(end);
        if(oldWeight.equals("0")){
//            说明需要insert
            Anima.save(new scenePath(Integer.parseInt(newweight),start,end));
            symbol="1";
        }
        else{
//            先拿到主键，然后upload
            List<scenePath> allPath=Anima.select().from(scenePath.class).all();
            int id=allPath.stream().filter(path->{
                String testStr=path.getStartNode()+" "+path.getEndNode();
               return  testStr.indexOf(start)>=0 && testStr.indexOf(end)>=0;
            }).collect(Collectors.toList()).get(0).getId();
            scenePath uploadPath=new scenePath(Integer.parseInt(newweight),start,end);
            uploadPath.setId(id);
            uploadPath.update();
            symbol="2";
        }
        return symbol;
    }
}
