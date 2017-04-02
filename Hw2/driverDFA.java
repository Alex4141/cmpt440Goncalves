/**
* file: driverDFA.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: project 1
* due date: March 20th, 2017
* version 1
*
* driverDFA
* This class is the driver class for the Man Wolf Goat Cabbage
* Problem. It creates an object from the ManWolf class and 
* passes the command line argument to determine it's validity.
*/

class driverDFA {
  
  /*
  * This is the driver for the Man Goat Wolf Cabbage problem.
  * Creates a new instance of the ManWolf object, and takes the
  * command line argument into ManWolf processing and prints out
  * it's result: whether or not the input is a valid solution.
  */

  public static void main(String args[]){
    ManWolf solution = new ManWolf();
    System.out.println(solution.process(args[0]));	
  }

}