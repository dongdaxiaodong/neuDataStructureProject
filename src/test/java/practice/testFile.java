package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class testFile {
    private static final String root="src/test/java/practice/one1.txt";

    public static void main(String[] args){
        try {
            BufferedReader bf=new BufferedReader(new FileReader(testFile.root));
            bf.lines().forEach(line->{
                System.out.println(line.length()+line);
            });
        }
        catch (Exception e){

        }
        try{
            Scanner input=new Scanner(new File(testFile.root));
            while (input.hasNext()){
                String theStr=input.nextLine();
                System.out.println(theStr.length()+theStr.substring(0,1));
            }
        }
        catch (Exception e){

        }
    }

}
