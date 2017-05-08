/**
* file: Echo.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Echo class
* which outputs some input onto the screen.
*/

import java.util.ArrayList;

/*
* Echo
*
* This class outputs some input from the UI
* onto the screen.
*/

class Echo extends Command {
	
  public static final String name = "echo";

  public static final int PARAM_LEN = 1;
  public static final int OPTION_LEN = 1;

  /*
  * execute
  * Return Type: String
  *
  * This function takes both the parameter arraylist, and the options
  * araylist. It formats the output into one string and either sets it to
  * capitalized or lowercase depending on the option.
  */

  public String execute(ArrayList<String> param, ArrayList<String> option){
    String result = param.get(0);

    for(int i = 1; i < param.size(); i++){
      result = result + " " + param.get(i);
    }

    if(option.size() > 0){
      if(option.get(0).equals("-help")){
        return "Echos the input to the screen. Can include -up for uppercase and -low for lowercase";
      } else if(option.get(0).equals("-up")){
          return result.toUpperCase();
      } else{
          return result.toLowerCase();
      }
    } else {
      return result;
    }
  }
}