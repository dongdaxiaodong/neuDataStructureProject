package com.bladejava.config;

import com.blade.ioc.annotation.Bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bladejava.service.projectDataStructure.sceneGraph;
import com.bladejava.service.projectDataStructure.scenePath;
import com.bladejava.service.definedDataStructure.myLinkedList;
import com.bladejava.service.projectDataStructure.sceneNode;

@Bean
public class systemConfig  {
    public sceneGraph mySceneGraph;
    public ArrayList<String> sightTips;

    public void upload(){
        /* todo--初始化 包括读入两个文件以及生成graph*/
        Connection c = null;
        Statement stmt=null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:system.db");
            myLinkedList<sceneNode> sceneNodeList=new myLinkedList<>();
            myLinkedList<scenePath> scenePathList=new myLinkedList<>();


            System.out.println("Opened database successfully");
            stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM node;");
            while (rs.next()){
                String name=rs.getString("name");
                String des=rs.getString("des");
                String popu=rs.getString("popu");
                boolean leisure=rs.getString("leisure").equals("1");
                boolean toilet=rs.getString("toilet").equals("1");
                String turn=rs.getString("turn");
                sceneNodeList.add(new sceneNode(name,des,Integer.parseInt(popu),leisure,toilet,Integer.parseInt(turn)));
            }
            ResultSet rs2=stmt.executeQuery("SELECT * FROM path;");
            while (rs2.next()){
                String start=rs.getString("start");
                String end=rs.getString("end");
                int weight=Integer.parseInt(rs.getString("weight"));
                scenePathList.add(new scenePath(weight,start,end));
                scenePathList.add(new scenePath(weight,end,start));
                mySceneGraph=new sceneGraph(sceneNodeList,scenePathList);
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
}
