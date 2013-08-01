import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class rovers_main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("file.txt");
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String line = null;
		    line=reader.readLine();
		    int index=line.indexOf(" ");
		    int b1=Integer.parseInt(line.substring(0,index));
		    int b2=Integer.parseInt(line.substring((index+1),line.length()));
		    if(b1>0 && b2>0)
		    {
		    	boolean check=true;
		    	boolean check2=true;
		    	while ((line = reader.readLine()) != null)
		    	{
	    			check2=true;
		    		index=line.indexOf(" ");
		    		String ex=line.substring(0,index);
		    		int a=Integer.parseInt(ex);
			    	int b=Integer.parseInt(line.substring((index+1),line.indexOf(" ",index+1)));
			    	char c= line.charAt(line.indexOf(" ",index+1)+1);
			    	if(a>0 && b>0 && check==true)
			    	{
			    		rovers r=new rovers(a,b,c);
			    		r.setBoundaries(b1,b2);
			    		line=reader.readLine();
			    		for(int i=0;i<line.length() && check==true;i++)
			    		{
			    			char cmd=line.charAt(i);
			    			if(cmd=='L' || cmd=='R' || cmd=='M')
			    			{
			    				if(cmd=='M')
			    				{
			    					if(r.checkPosition()==true)
			    					{
			    						System.out.println("Rover is going out of bounds"+"\n");
			    						check2=false;
			    					}
			    				}
			    				r.turn_moveRover(cmd);
			    				if(r.checkPosition()==true)
			    				{
		    						System.out.println("Rover is going out of bounds" +"\n");
		    						check2=false;
		    					}
			    				
			    			}
			    			else
			    			{
			    				System.out.println("Please give valid direction for rover to move"+"\n");
			    				check2=false;
			    			}
			    		}
			    		if(check2==true)
			    		r.printRovers();
			    	}
			    	else 
			    	{
			    		System.out.println("Give the coordinates equal to or greater than 1"+"\n");
			    		line=reader.readLine();
			    	}
	    		}
	    	}
	    
		    else
		    	System.out.println("Give the coordinates equal to or greater than 1"+"\n");
		    return;
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}

	}

}
