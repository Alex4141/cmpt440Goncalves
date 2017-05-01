/**
* file: Mkdir.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Mkdir class
* which created a directory if it doesn't already exist.
*/

import java.io.File;
import java.util.ArrayList;

/*
* Mkdir
*
* This class is used to create new directories.
*/

class Mkdir extends Command {
	
  public static final String name = "mkdir";

  public static final int PARAM_LEN = 1;
  public static final int OPTION_LEN = 0;

  /*
  * execute
  * Return Type: String
  *
  * This class takes the parameter arraylist,
  * with a full directory path and creates a directory assuming
  * it's a valid path and the directory does not exist.
  */

  public String execute(ArrayList<String> param){
		
    File newDirectory = new File(param.get(0));

    boolean directoryCreated = newDirectory.mkdir();

    if(directoryCreated){
      return "Directory created!";
    } else {
      return param.get(0) + " not made!";
    }
  }
}