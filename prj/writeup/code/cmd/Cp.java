/**
* file: Cp.java
* author: Alexander Goncalves
* course: CMPT 440
* assignment: final project
* due date: May 1st 2017
*
* This file contains the Cp class
* which copies one file to another location.
*/

import java.util.ArrayList;
import java.io.*;

/*
* Cp
* An extension of the Command class, is used
* to copy one file to another directory.
*/

class Cp extends Command{

  public static final String name = "cp";

  public static final int PARAM_LEN = 2;
  public static final int OPTION_LEN = 0;

  /*
  * execute
  * Return Type: String
  *
  * This function takes the parameter array list, containing
  * a full path to a file and a full path to a directory
  * and copies the file to the directory. Returns whether or 
  * not the copy is successful.
  */

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

      return "File copied";
    } catch (IOException e){
      return "Copying failed";
    } 
  }
}