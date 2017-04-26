import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

class Head extends Command {
	public static final String name= "head";

	public static final int PARAM_LEN = 1;
	public static final int OPTION_LEN = 1;

	public String execute(ArrayList<String> param, int option){
		String result = "";
		
		File currFile = new File(param.get(0));

		if(currFile.isDirectory()){
			return "The specified path does not contain a file";
		}

		try {
		BufferedReader buff = new BufferedReader(new FileReader(currFile));

		int lines = 0;
		String line = "";

		while((lines < option) && (line = buff.readLine()) != null){
			result += line + "\n";
			lines++;
		}

		return result;

		} catch(IOException e){
			return "The specified file does not exist";
		}
	}
}