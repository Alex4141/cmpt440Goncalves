import java.util.ArrayList;
import java.io.File;

class Rm extends Command {
	public static final String name = "rm";

	public static final int PARAM_LEN = 1;
	public static final int OPTION_LEN = 1;

	public String execute(ArrayList<String> param, ArrayList<String> option){
		if(option.size() != 0){
			return "This command takes an absolue path to the file to be deleted";
		}

		File currFile = new File(param.get(0));

		boolean deleted = currFile.delete();
		
		if(deleted){
			return "File " + param.get(0) + " deleted";
		} else{
			return "File does not exist";
		}
	}
}