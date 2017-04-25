import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Touch extends Command {
	public static final String name= "touch";

	public static final int PARAM_LEN = Integer.MAX_VALUE;
	public static final int OPTION_LEN = 0;

	public String execute(ArrayList<String> param){
		for(int i = 0; i < param.size(); i++){

			String path;
			if(this.OS.contains("Windows")){
				path = "C:\\Users\\" + (String)System.getProperty("user.name") + "\\Desktop\\";
			} else if(this.OS.contains("Mac")){
				path = "/Users/" + (String)System.getProperty("user.name") + "/Desktop/";
			} else {
				path = "/home/" + (String)System.getProperty("user.name") + "/Desktop/";
			}			

			File currInput = new File(path + param.get(i));
			try {
				if(currInput.createNewFile()){
					continue;
				} else {
					return "Failed on file: " + param.get(i);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		if(param.size() == 1){
			return "File created";
		} else{
			return "Files created";
		}
		
	}
}