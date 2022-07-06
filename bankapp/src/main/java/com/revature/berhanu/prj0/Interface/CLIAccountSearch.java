package com.revature.berhanu.prj0.Interface;
import java.util.*;
public class CLIAccountSearch {
    public void searchAccount(){
        
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Input a search term, to find account  informaiton related to it");
        String searchTerm = objScanner.nextLine();
        System.out.println("Searching for:" + searchTerm);
         

        

        objScanner.close();
    }
}
