import java.io.File;
import java.util.ArrayList;

class Mkdir extends Command {
	
	public static final String name = "mkdir";

	public static final int PARAM_LEN = 1;
	public static final int OPTION_LEN = 0;

	public String execute(ArrayList<String> param){
		File newDirectory = new File(param.get(0));

		boolean directoryCreated = newDirectory.mkdir();

		if(directoryCreated){
			return "Directory Created";
		} else {
			return param.get(0) + " is not a proper path";
		}
	}

}