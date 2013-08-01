import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class AllTests {

	private static rovers r;
	
	public static void init() throws IOException{
		r.setBoundaries(5, 5);
	}
	@Test
	public void test() {
		r=new rovers(4,3,'N');
		String command="LMLMLMLMM";
		for(int i = 0; i <command.length(); ++i) {
		    r.turn_moveRover(command.charAt(i));
		}
		assertEquals("1 3 N",r.print());

	}
	
	public void test2() {
		r=new rovers(3,3,'E');
		String command="MMRMMRMRRM";
		for(int i = 0; i <command.length(); ++i) {
		    r.turn_moveRover(command.charAt(i));
		}
		assertEquals("5 1 E",r.print());

	}
}
