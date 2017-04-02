import java.util.ArrayList;
import java.util.HashSet;

class TerminalDFA {
	final int Q0 = 0; // Nothin
	final int Q1 = 1; // Whoami
	final int Q2 = 2; // Whoami + Name
	final int Q3 = 3; // Mkdir
	final int Q4 = 4; // Mkdi + Path
	final int Q5 = 5; // Error

	final ArrayList<String> option = new ArrayList<String>();
	final ArrayList<String> params = new ArrayList<String>();

	final Whoami whoami;
	final Mkdir mkdir;

	// TODO Make the Table DFA after ~8-10 commands finished, for now switch case
	// because the library of commands isn't done

	public TerminalDFA(){
		this.whoami = new Whoami();
		this.mkdir = new Mkdir();
	}

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
						default:
							state = Q5;
							break;
					}
				case Q1:
					switch(input[i]){
						case "-help":
							option.add(input[i]);
							state = Q2;
							break;
						default:
							state = Q5;
							break;
					}
				case Q2:
					state = Q5;
					break;
				case Q3:
					state = Q4;
					break;
				case Q4:
					params.add(input[i]);
					state = Q5;
					break;
				case Q5:
					break;
			}
		}
		return state;
	}

	public String getResult(int stateValue){
		switch(stateValue){
			case Q1:
				return whoami.execute(option);
			case Q2:
				return whoami.execute(option);
			case Q4:
				return mkdir.execute(params);
			default:
				return "Error";
		}
	}

}