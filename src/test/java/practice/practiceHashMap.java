package practice;

import java.util.HashMap;

public class practiceHashMap {
    public static void main(String[] args){
        HashMap<String,Integer> myHash=new HashMap<>();
        myHash.put("colin",111);
        myHash.put("rachel",222);
        System.out.println(myHash.containsKey("colin"));
    }
}
