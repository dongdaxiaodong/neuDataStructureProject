package practice;

import java.util.LinkedList;
import com.bladejava.service.algorithm.hamiltonian;
public class testHami {
    public static void main(String[] args){
        LinkedList<LinkedList<String>> hamiList=hamiltonian.hamiPath("北门");
        System.out.println(hamiList);
    }
}
