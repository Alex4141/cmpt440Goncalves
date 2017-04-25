import java.util.ArrayList;
/*
* This class implements the base class
* for all other commands for this terminal.
*/
class Command {
	public static final String TYPE = "Command";
	public static final String OS = (String) System.getProperty("os.name");

	public String execute(ArrayList<String> option, ArrayList<String> params){
		return "Empty Command";
	}
}