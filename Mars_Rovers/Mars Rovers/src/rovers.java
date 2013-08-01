import java.io.IOException;

public class rovers {
	private int x;
	private int y;
	private char dir;
	private int boundary_a;
	private int boundary_b;
	public rovers(){
	
		this.x=0;
		this.y=0;
		this.dir='\0';
	}
	
	public rovers(int xcor,int ycor,char dir){
		this.x=xcor;
		this.y=ycor;
		this.dir=dir;
	}

	public void setBoundaries(int a,int b) throws IOException{
		if(a >0 && b>0){
			this.setBoundary_a(a);
			this.setBoundary_b(b);
		}
		else{
			System.out.println("Give the coordinates equal to or greater than 1");
			return;
		}
	}
	public void setPosition(int xcor,int ycor,char direc){
		x=xcor;
		y=ycor;
		dir=direc;
	}
	public boolean checkPosition()
	{
		if(this.x<0 || this.y<0)
			return true;
		return false;
	}

	public rovers turn_moveRover(char cmd){
		if(cmd=='L'){
			if(this.dir=='N')
				this.dir='W';
			else if(this.dir=='S')
				this.dir='E';
			else if(this.dir=='W')
				this.dir='S';
			else if(this.dir=='E')
				this.dir='N';
		}
		else if(cmd=='R'){
			if(this.dir=='N')
				this.dir='E';
			else if(this.dir=='S')
				this.dir='W';
			else if(this.dir=='W')
				this.dir='N';
			else if(this.dir=='E')
				this.dir='S';
		}
		else if(cmd=='M'){
			if(this.dir=='N'){
				this.y++;
			}
			else if(this.dir=='S'){
				this.y--;
			}
			else if(this.dir=='W'){
				this.x--;
			}
			else if(this.dir=='E'){
				this.x++;
			}
			else
			{
				System.out.println("Please give valid direction for rover to move");
			}
		}
		else 
			System.out.println("Please give valid direction to turn");
		return this;
		
	}
	
	public void printRovers(){
		System.out.println(this.x+" "+this.y+" "+this.dir+"\n");
		
	}
	public String print(){
		String a= "";
		a=this.x+" "+this.y+" "+this.dir;
		return a;
	}

	public int getBoundary_a() {
		return boundary_a;
	}

	public void setBoundary_a(int boundary_a) {
		this.boundary_a = boundary_a;
	}

	public int getBoundary_b() {
		return boundary_b;
	}

	public void setBoundary_b(int boundary_b) {
		this.boundary_b = boundary_b;
	}
		
}
	
