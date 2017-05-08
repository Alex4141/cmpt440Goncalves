/**
* file: Man.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Man class
* which tells the user what the commands do.
*/

import java.util.ArrayList;

/*
*  Man
*
*  This class returns a description of a certain command
*/

class Man extends Command {

  public static final String name = "man";

  public static final int PARAM_LEN = 1;
  public static final int OPTION_LEN = 0;

  /*
  * execute
  * Return Type: String
  *
  * This method returns a description of a particular command.
  */

  public static String execute(ArrayList<String> param){
    String command = param.get(0);

    switch(command){
      case "whoami":
        return "This command returns the user using the application";
      case "cp":
        return "This command copies one file to another directory";
      case "echo":
        return "This command returns a given input to the screen";
      case "head":
        return "Returns the first 10 or less lines of a file";
      case "man":
        return "Returns information about commands in the system";
      case "rm":
        return "This commands removes the specified file if it exists";
      case "touch":
        return "This command creates a file if it doesn't exist";
      case "mkdir":
        return "This command makes a new directory with the name specified";
      default:
        return command + " is not a valid command";
    }
  }
}