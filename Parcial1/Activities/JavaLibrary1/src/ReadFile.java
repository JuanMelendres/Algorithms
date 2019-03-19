import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

  public static void main(String args[]) {
    List<String> input = new ArrayList<>();
    List<String> output = new ArrayList<>();
    try {
      // Open the file that is the first 
      // command line parameter
      FileInputStream fstream = new FileInputStream("./Test.txt");
      // Get the object of DataInputStream
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      //Read File Line By Line
      while ((strLine = br.readLine()) != null)   {
        if (!strLine.startsWith("#") && !strLine.startsWith("----------")) {
          if (strLine.equals("Input:")) {
            System.out.print("Found ");
            input.add(strLine);
          }
          else if (strLine.equals("Output:")) {
            System.out.print("Found ");
          }
          output.add(strLine);
          System.out.println(strLine);
          // if (!strLine.startsWith("Input:")) {
          //   System.out.println(strLine);
          //   //br.readLine();
          //   //input.add(strLine);
          // }
          // else if (!strLine.startsWith("Output:")) {
          //   //br.readLine();
          //   System.out.println(strLine);
          // }
          //System.out.println(strLine);
          // if (!strLine.startsWith("Input:") && !strLine.startsWith("Output:")) {
          //   result.add(strLine);
          //   //System.out.println(strLine);
          // }
        }
      }
      //Close the input stream
      in.close();
    }
    catch (Exception e) {//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    // System.out.println("Input:");
    // for(int i = 0; i < input.size(); i++) {
    //   System.out.println(input.get(i));
    // }
    // System.out.println("Output:");
    // for(int i = 0; i < output.size(); i++) {
    //   System.out.println(output.get(i));
    // }
  }

}