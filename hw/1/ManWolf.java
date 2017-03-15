class ManWolf {
  private static final int Q0 = 0;
  private static final int Q1 = 1;
  private static final int Q2 = 2;
  private static final int Q3 = 3;
  private static final int Q4 = 4;
  private static final int Q5 = 5;
  private static final int Q6 = 6;
  private static final int Q7 = 7;
  private static final int Q8 = 8;
  private static final int Q9 = 9;
  private static final int Q10 = 10;
        
  /*
  For this 2-dimensional array table implementation,
  assume that for our alphabet, the symbols are refered
  to in the order of: NGWC
  */

  public static final int[][]delta =
    {{Q10,Q1,Q10,Q10},{Q2,Q0,Q10,Q10}, {Q1,Q10,Q3,Q5},
    {Q10,Q4,Q2,Q10}, {Q10,Q3,Q10,Q7}, {Q10,Q6,Q10,Q2},
    {Q10,Q5,Q7,Q10}, {Q8,Q10,Q6,Q4}, {Q7,Q9,Q10,Q10},
    {Q10,Q8,Q10,Q10}, {Q10, Q10, Q10, Q10}};

  /*
  * Process is a function that takes some string, an attempted solution,
  * as an input to the Man Wolf Goat Cabbage problem.
  *
  * Using the delta table, the function iterates through the characters
  * and switches the input's state appropriately.
  *
  * The problem has one accepting state: Q9. After switching states
  * using the input, it compares the final state to the accepting state.
  */

  public String process(String input){ 		
    int state = 0;

    for(int i = 0; i < input.length(); i++){
      char current = input.charAt(i);
    	
      switch(current){
        case 'n': state = delta[state][0]; break;
    	case 'g': state = delta[state][1]; break;
    	case 'w': state = delta[state][2]; break;
        case 'c': state = delta[state][3]; break;
      }
    }

    if(state == Q9){
      return "That is a solution";
    } else {
      return "That is not a solution";
    }
  }
 
}