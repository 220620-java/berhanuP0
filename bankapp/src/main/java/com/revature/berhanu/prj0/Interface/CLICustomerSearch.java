package com.revature.berhanu.prj0.Interface;
import java.util.*;

import com.revature.berhanu.prj0.Models.User;
public class CLICustomerSearch {
    public void searchCustomer(){
        
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Input a search term, to find customer informaiton related to it");
        String searchTerm = objScanner.nextLine();
        System.out.println("Searching for:" + searchTerm);
         

        User objUser= new User();
        objUser.searchUser(searchTerm);

        objScanner.close();
    }
}
