import java.io.File;
import java.util.ArrayList;

class Mkdir extends Command {
	
	public static final String name = "mkdir";

	public static final int PARAM_LEN = 1;
	public static final int OPTION_LEN = 0;

	public String execute(ArrayList<String> param){
		
		String path;
		if(this.OS.contains("Windows")){
			path = "C:\\Users\\" + (String)System.getProperty("user.name") + "\\Desktop\\";
		} else if(this.OS.contains("Mac")){
			path = "/Users/" + (String)System.getProperty("user.name") + "/Desktop/";
		} else {
			path = "/home/" + (String)System.getProperty("user.name") + "/Desktop/";
		}

		File newDirectory = new File(path + param.get(0));

		boolean directoryCreated = newDirectory.mkdir();

		if(directoryCreated){
			return "Directory created on Desktop";
		} else {
			return param.get(0) + " already exists!";
		}
	}

}