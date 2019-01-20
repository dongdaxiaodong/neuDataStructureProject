package practice;
import com.bladejava.service.definedDataStructure.myLinkedList;
public class practiceMyLinkedList {
    public static void main(String[] args){
        myLinkedList<String> myLinkedList=new myLinkedList<>();
        for(int i=0;i<30;i+=1){
            myLinkedList.add(""+i);
        }
        myLinkedList.remove(10);
        myLinkedList.remove("1");
        myLinkedList.toOutput();
//        System.out.println(myLinkedList.actualLength);
//        System.out.println(myLinkedList.length);
    }
}
