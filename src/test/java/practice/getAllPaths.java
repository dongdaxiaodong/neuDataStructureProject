package practice;

import com.bladejava.service.projectDataStructure.scenePath;
import io.github.biezhi.anima.Anima;

import java.util.List;
import java.util.stream.Collectors;

public class getAllPaths {
    public static void main(String[] args){
        List<scenePath> allPaths= Anima.select().from(scenePath.class).all();
        List<String> startNames=allPaths.stream().
                map(path->path.getStartNode()).collect(Collectors.toList());
        List<String> endNames=allPaths.stream().
                map(path->path.getEndNode()).collect(Collectors.toList());
        startNames.addAll(endNames);
        List<String> nameList=startNames.stream().distinct().collect(Collectors.toList());
    }
}
