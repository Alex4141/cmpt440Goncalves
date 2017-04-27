import java.util.ArrayList;
import java.util.HashSet;

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
	final int Q10  10; // Man + param
	final int Q11 = 11; // Rm
	final int Q12  12; // Rm + option
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

	int[][] table = {
		{Q24,Q1,Q24,Q3,Q24,Q5,Q24,Q24,Q24,Q9,Q24,Q11,Q24,Q24,Q24,Q15,Q24,Q24,Q18,Q24,Q20,Q24,Q24,Q24,Q24}, //0
		{Q24,Q24,Q2,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //1
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //2
		{Q24,Q24,Q24,Q24,Q4,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //3
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //4
		{Q24,Q24,Q24,Q24,Q24,Q24,Q6,Q24,Q8,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //5
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q7,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //6
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //7
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //8
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q10,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //9
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //10
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q12,Q24,Q14,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //11
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q13,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //12
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //13
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //14
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q16,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //15
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q17,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //16
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //17
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q19,Q24,Q24,Q24,Q24,Q24}, //18
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q19,Q24,Q24,Q24,Q24,Q24}, //19
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q21,Q24,Q23,Q24}, //20
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q22,Q24,Q24}, //21
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //22
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //23
		{Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24,Q24}, //24
	};

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