/**
* file: Head.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Head class
* which outputs the first several lines of a file.
*/

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/*
* Head
*
* This class outputs the first several
* lines of some text file
*/

class Head extends Command {
  public static final String name= "head";

  public static final int PARAM_LEN = 1;
  public static final int OPTION_LEN = 1;

  /*
  * execute
  * Return type: String
  *
  * This function takes both parameter and option arraylists,
  * the parameter should contain a full path, and the option should be
  * some number < 10, for the lines of the files.
  */

  public String execute(ArrayList<String> param, ArrayList<String> option){
    String result = "";
		
    File currFile = new File(param.get(0));

    if(currFile.isDirectory()){
      return "The specified path does not contain a file";
    }

    try {
      BufferedReader buff = new BufferedReader(new FileReader(currFile));

      int lines = 0;
      String line = "";

      String len = option.get(0);
      len = len.substring(1, len.length());

      int optionValue = Integer.parseInt(len);
      if(optionValue > 10){
      	optionValue = 10;
      }

      while((lines < optionValue) && (line = buff.readLine()) != null){
        result += line + "\n";
        lines++;
      }

      buff.close();

      return result;
    } catch(IOException e){
        return "The specified file does not exist";
    }
  }
}