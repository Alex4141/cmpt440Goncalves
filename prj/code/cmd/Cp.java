import java.util.ArrayList;
import java.io.*;

class Cp extends Command{

	public static final String name = "cp";

	public static final int PARAM_LEN = 2;
	public static final int OPTION_LEN = 0;

	public String execute(ArrayList<String> param) {
		File toCopy = new File(param.get(0));

		if(!toCopy.exists() || toCopy.isDirectory()){
			return "The file and path: " + param.get(0) + " does not exist";
		}

		File targetDirectory = new File(param.get(1));
		
		if(!targetDirectory.isDirectory()){
			return "The directory path: " + param.get(1) + " does not exist";
		}

		String[] result;
		String path;

		if(this.OS.contains("Windows")){
			result = param.get(0).split("\\\\");
			path = param.get(1) + "\\" + result[result.length - 1];
		} else {
			result = param.get(0).split("/");
			path = param.get(1) + "/" + result[result.length - 1];
		}

		File newFile = new File(path);

		try {
		InputStream in = new FileInputStream(toCopy);
		OutputStream out = new FileOutputStream(newFile);
		
		byte[] buffer = new byte[1024];		
		int len;

		while((len = in.read(buffer)) > 0){
				out.write(buffer, 0, len);		
		} 

		in.close();
		out.close();

		} catch (IOException e){
			e.printStackTrace();
		} 


		return "File copied";

	}

}