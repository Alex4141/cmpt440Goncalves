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