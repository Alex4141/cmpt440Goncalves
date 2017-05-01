/**
* file: Command.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Command class
* which is the basis for all of my commands.
*/

import java.util.ArrayList;

/*
* Command
*
* This class implements the base class
* for all other commands for this terminal.
*/
class Command {
  public static final String TYPE = "Command";
  public static final String OS = (String) System.getProperty("os.name");

	/*
	* execute
	* Return Type: String
	*
	* This is the base method of execute, from which all
	* the subclasses inherit. This particular classes's will
	* never be used.
	*/

  public String execute(ArrayList<String> option, ArrayList<String> params){
    return "Empty Command";
  }
}