package practice;

import com.bladejava.service.projectDataStructure.scenePath;
import io.github.biezhi.anima.Anima;

import java.util.List;

public class testdb {
    public static void main(String[] args){
        List<scenePath> allPath= Anima.select().from(scenePath.class).all();
        for(int i=0;i<allPath.size();i+=1){
//            System.out.println(allPath.get(i).ge);
        }
    }
}
