package practice;

import java.util.LinkedList;

public class testObj {
    public static void main(String[] args){
        LinkedList<String> myList=new LinkedList<>();
        myList.add("ok");
        myList.add("owe");
        System.out.println(myList.size());
        LinkedList<String> yourList=new LinkedList<>();
        yourList=(LinkedList<String>) myList.clone();
        yourList.add("fwe");
        System.out.println(myList);
    }
}
