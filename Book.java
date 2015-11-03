import java.io.*;
import java.util.*;

public class Book extends Readable{
	private BufferedReader reader;
	private FileReader in;
	ArrayList<ArrayList<String>> lineList;
	//private FileWriter out;

	public Book(int price,int sNo,String authorName){
		super(price,sNo,authorName);
		lineList = new ArrayList<ArrayList<String>>();
	}

	@Override
	// this won't work cause 1.02 is a float
	public int getPrice(){
		//return 1.02 * price;
		return price;
	}

	public int getListInfo(){
		//Based on the value of Type(Book or eBook) print the list of Items
		// What does that mean ?
		return 0;
	}

	public void readFile(){
		try {
        	reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();

            while (line!=null) {
                // Print read line
                System.out.println(line);
                lineList.add(new ArrayList<String>(Arrays.asList(line.split(","))));
                // Read next line for while condition
                line = reader.readLine();
            }
        }catch (IOException e){
        	// do the thing
        }finally {
         	try {
	         	if (in != null) {
	            	in.close();
	        	}
	        	if (reader != null){
	        		reader.close();
	        	}
	        }catch (IOException e){
	         	// do the thing
	         }
      	}
	}
}