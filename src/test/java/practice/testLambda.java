package practice;

import com.bladejava.service.projectDataStructure.car;
import io.github.biezhi.anima.Anima;

import java.util.List;
import java.util.stream.Collectors;

public class testLambda {
    public static void main(String[] args){
        List<car> cars= Anima.select().from(car.class).filter(car->car.getStatus().equals("3")).collect(Collectors.toList());
        System.out.println(cars.size());
    }
}
