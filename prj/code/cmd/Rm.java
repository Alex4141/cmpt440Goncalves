/**
* file: Rm.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Rm class
* which removes a file.
*/

import java.util.ArrayList;
import java.io.File;

/*
* Rm
*
* The rm class removes a file given a full path to it.
*/

class Rm extends Command {
  public static final String name = "rm";

  public static final int PARAM_LEN = 1;
  public static final int OPTION_LEN = 1;

  /*
  * execute
  * Return Type: String
  *
  * This method takes a full path to a given file and
  * removes it from memory. It will return to the UI
  * whether or not the file was deleted.
  */

  public String execute(ArrayList<String> param, ArrayList<String> option){
    if(option.size() != 0){
      return "This command takes an absolue path to the file to be deleted";
    }

    File currFile = new File(param.get(0));

    boolean deleted = currFile.delete();
		
    if(deleted){
      return "File " + param.get(0) + " deleted";
    } else{
      return "File does not exist";
    }
  }
}