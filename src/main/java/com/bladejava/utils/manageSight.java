package com.bladejava.utils;

import com.bladejava.service.projectDataStructure.sceneNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class manageSight {

    public static void addNewNode(ArrayList<sceneNode> newList){
        String filePath="src/main/java/com/bladejava/service/sceneInformation.txt";
        String strStream="";
        for(int i=0;i<newList.size();i+=1){
            String name=newList.get(i).getSceneName();
            String des=newList.get(i).getDescription();
            String popularity=(newList.get(i).getPopularity())+"";
            String leisure=(newList.get(i).getHasLeisure())?"1":"0";
            String toilet=(newList.get(i).getHasToilet())?"1":"0";
            String turn=newList.get(i).getTurnstiles()+"";
            strStream+=name+","+des+","+popularity+","+leisure+","+toilet+","+turn+"\n";
        }
        File file=new File(filePath);
        try {

            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strStream);
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
