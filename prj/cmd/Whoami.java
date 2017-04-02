import java.util.ArrayList;

class Whoami extends Command{
	
	public static final String name = "whoami";

	public static final int PARAM_LEN = 0;
	public static final int OPTION_LEN = 1;

	public String execute(ArrayList<String> option){
		
		if(option.size() == 0){
			return (String)System.getProperty("user.name");
		} else {
			return "This command is used to determine the user";
		}
	}
}