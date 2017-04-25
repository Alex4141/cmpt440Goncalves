import java.util.ArrayList;

class Echo extends Command {
	
	public static final String name = "echo";

	public static final int PARAM_LEN = 1;
	public static final int OPTION_LEN = 1;

	public String execute(ArrayList<String> param, ArrayList<String> option){
		
		if(option.size() > 0){
			if(option.get(0) == "-help"){
				return "Echos the input to the screen. Can include -up for uppercase and -low for lowercase";
			} else if(option.get(0) == "-up"){
				return param.get(0).toUpperCase();
			} else{
				return param.get(0).toLowerCase();
			}
		} else {
			return param.get(0);
		}
	}
}