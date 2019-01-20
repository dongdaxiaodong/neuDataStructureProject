package practice;

import java.util.HashMap;

public class testHashMap {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("colin",3);
        hashMap.put("colin",5);
        System.out.println(hashMap);
    }
}
