import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

  public static void main(String args[]) {
    List<String> input = new ArrayList<>();
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
          if (!strLine.startsWith("Input:") && !strLine.startsWith("Output:")) {
            input.add(strLine);
          }
        }
      }
      //Close the input stream
      in.close();
    }
    catch (Exception e) {//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    for(int i = 0; i < input.size(); i++) {
      System.out.println(input.get(i));
    }
    if (input.get(2).equals("345")) {
      System.out.println("True");
    }
  }

}