/**
* file: Touch.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Touch class
* which creates new files.
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
* Touch
*
* This class creates new files in the Desktop diectory
*/

class Touch extends Command {
  public static final String name= "touch";

  public static final int PARAM_LEN = Integer.MAX_VALUE;
  public static final int OPTION_LEN = 0;

  /*
  * execute
  * Return Type: String
  *
  * This function takes a param full of file names and
  * creates them all on the Desktop, if any are used or
  * invald, this stop any other files from being created.
  */

  public String execute(ArrayList<String> param){
    for(int i = 0; i < param.size(); i++){

      String path;
      if(this.OS.contains("Windows")){
        path = "C:\\Users\\" + (String)System.getProperty("user.name") + "\\Desktop\\";
      } else if(this.OS.contains("Mac")){
        path = "/Users/" + (String)System.getProperty("user.name") + "/Desktop/";
      } else {
          path = "/home/" + (String)System.getProperty("user.name") + "/Desktop/";
      }			

      File currInput = new File(path + param.get(i));
      try {
        if(currInput.createNewFile()){
          continue;
        } else {
          return "Failed on file: " + param.get(i);
        }} catch (IOException e){
            return "Failed on file: " + param.get(i);
        }
    }
		
    if(param.size() == 1){
      return "File created";
    } else{
        return "Files created";
    }	
  }
}