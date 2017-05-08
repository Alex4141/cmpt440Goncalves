/**
* file: Whoami.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Whoami class
* which returns the user on the system.
*/

import java.util.ArrayList;

/*
* Whoami
*
* This class returns the user of the program.
*/

class Whoami extends Command{
	
  public static final String name = "whoami";

  public static final int PARAM_LEN = 0;
  public static final int OPTION_LEN = 1;

  /*
  * execute
  * Return type: String
  *
  * This method takes the option arraylist for the 
  * help option if needed, otherwise prints the 
  * current user.
  */

  public String execute(ArrayList<String> option){
		
    if(option.size() == 0){
      return (String)System.getProperty("user.name");
    } else {
      return "This command is used to determine the user";
    }
  }
}