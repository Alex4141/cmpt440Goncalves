/**
* file: TerminalDFA.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the TerminalDFA class
* which does all of the DFA processing
*/

import java.util.ArrayList;
import java.util.HashSet;

/*
*  TerminalDFA
*
* This class contains all the processing of user input
* in the UI and determines if we're left in a valid
* state, which triggers some execution and a return result.
* The class contains variables for all states and and instance of
* all of the commands.
*/

class TerminalDFA {

  final int Q0 = 0; // Nothing
  final int Q1 = 1; // Whoami
  final int Q2 = 2; // Whoami + option
  final int Q3 = 3; // Mkdir
  final int Q4 = 4; // Mkdir + param
  final int Q5 = 5; // Echo
  final int Q6 = 6; // Echo + option
  final int Q7 = 7; // Echo + option + param
  final int Q8 = 8; // Echo + param
  final int Q9 = 9; // Man
  final int Q10 = 10; // Man + param
  final int Q11 = 11; // Rm
  final int Q12 = 12; // Rm + option
  final int Q13 = 13; // Rm + option + param
  final int Q14 = 14; // Rm + param
  final int Q15 = 15; // Cp
  final int Q16 = 16; // Cp + param
  final int Q17 = 17; // Cp + param + param
  final int Q18 = 18; // Touch
  final int Q19 = 19; // Touch + param
  final int Q20 = 20; // Head
  final int Q21 = 21; // Head + option
  final int Q22 = 22; // Head + option + param
  final int Q23 = 23; // Head + param
  final int Q24 = 24; // Error State

  final Whoami whoami;
  final Mkdir mkdir;
  final Echo echo;
  final Touch touch;
  final Rm rm;
  final Man man;
  final Head head;
  final Cp cp;

  final ArrayList<String> option = new ArrayList<String>();
  final ArrayList<String> params = new ArrayList<String>();

/*
* TerminalDFA
* Constructor
* Creates a new instance of the object declarations above
*/

  public TerminalDFA(){
    this.whoami = new Whoami();
    this.mkdir = new Mkdir();
    this.echo = new Echo();
    this.touch = new Touch();
    this.rm = new Rm();
    this.man = new Man();
    this.head = new Head();
    this.cp = new Cp();
  }

  /*
  * process
  * Return Type: Int
  *
  * This is the essential function, it's the state machine
  * and processes input based on the state + input.
  */

  public int process(String[] input){
    int state = 0;

    for(int i = 0; i < input.length; i++){
      switch(state){
        case Q0:
          switch(input[i]){
            case "whoami":
              state = Q1;
              break;
            case "mkdir":
              state = Q3;
              break;
            case "echo":
              state = Q5;
              break;
            case "man":
              state = Q9;
              break;
            case "rm":
              state = Q11;
              break;
            case "cp":
              state = Q15;
              break;
            case "touch":
              state = Q18;
              break;
            case "head":
              state = Q20;
              break;
            default:
              state = Q24;
              break;
          }
					break;

        case Q1:
          switch(input[i]){
            case "-help":
               option.add(input[i]);
               state = Q2;
               break;
            default:
              state = Q24;
              break;
          }
        break;

        case Q2:
          state = Q24;
          break;

        case Q3:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q4;
          }
        break;

        case Q4:
          state = Q24;
          break;

        case Q5:
          if(input[i].equals("-help") || input[i].equals("-up") || input[i].equals("-down")){
            option.add(input[i]);
            state = Q6;
          } else if(!input[i].contains("-")) {
              params.add(input[i]);
              state = Q8;
          } else {
              state = Q24;
          }
        break;

        case Q6:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q7;
          }
        break;

        case Q7:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q7;
          }
        break;

        case Q8:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q8;
          }
        break;

        case Q9:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q10;
          }
        break;

        case Q10:
          state = Q24;
        break;

        case Q11:
          if(input[i] == "-help"){
            option.add(input[i]);
            state = Q12;
          } else {
              params.add(input[i]);
              state = Q14;
          }
        break;

        case Q12:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q13;
          }
        break;

        case Q13:
          state = Q24;
        break;

        case Q14:
          state = Q24;
        break;

        case Q15:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q16;
          }
        break;

        case Q16:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q17;
          }
        break;

        case Q17:
          state = Q24;
        break;

        case Q18:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q19;
          }
        break;

        case Q19:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
		      state = Q19;
          }
        break;

        case Q20:
          if(input[i].charAt(0) == '-'){
            option.add(input[i]);
            state = Q21;
          } else {
              params.add(input[i]);
              state = Q23;
          }
        break;

        case Q21:
          if(input[i].charAt(0) == '-'){
            state = Q24;
          } else {
              params.add(input[i]);
              state = Q22;
          }
        break;

        case Q22:
          state = Q24;
        break;

        case Q23:
          state = Q24;
        break;

        case Q24:
          state = state;
        break;

        default:
          state = Q24;
        break;
      }
    }
  return state;
  }

  /*
  * getResult
  * Return Type: String
  *
  * This function takes the result of the DFA
  * table and gets the result of the correct object
  * performing it's execution.
  */

  public String getResult(int stateValue){
    switch(stateValue){
      case Q1:
        return whoami.execute(option);
      case Q2:
        return whoami.execute(option);
      case Q4:
        return mkdir.execute(params);
      case Q7:
        return echo.execute(params, option);
      case Q8:
        return echo.execute(params, option);
      case Q10:
        return man.execute(params);
      case Q13:
        return rm.execute(params, option);
      case Q14:
        return rm.execute(params, option);
      case Q17:
        return cp.execute(params);
      case Q19:
        return touch.execute(params);
      case Q22:
        return head.execute(params, option);
      case Q23:
        option.add("-10");
        return head.execute(params, option);
      default:
        return "This is not a valid state";
      }
  }

  /*
  * clearCache
  * Return Type: Void
  *
  * This is a helper function to clear the 
  * ArrayLists, its used upon completion of DFA.
  */

  public void clearCache(){
    option.clear();
    params.clear();
  }

  /*
  * processString
  * Return Type: String
  * A wrapper function for all of the functionality in this class
  * The input from the UI is passed here and split on spaces, the 
  * state is extracted and a result is gotten dependent on the state
  */

  public String processString(String input){
    String[] toProcess = input.split(" ");
    int state = process(toProcess);
		
    String result = getResult(state);
    clearCache();

    return result;
  }
}