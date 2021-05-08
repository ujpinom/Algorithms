package grafos;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class PerfectMaze {
	
	private int N; //Matriz de N*N
	private direccion [][]  grid;
	private int [] movimientos= {1,0,-1,0,0,1,0,-1};
	
	private boolean resuelto;
	

	public PerfectMaze(int N,String resolver) {
		StdDraw.enableDoubleBuffering();
		  StdDraw.setXscale(0, N+2);
	      StdDraw.setYscale(0, N+2);
		this.N=N+2;
		
		grid= new direccion[N+2][N+2];
		
		for(int i=0;i<N+2;i++) {
			for(int j=0;j<N+2;j++) {
				grid[i][j]= new direccion();
				if(i==0 || i==N+1 || j==0 || j==N+1) {
					grid[i][j].visitado=true;
				}
			}
		}

	generar(1,1);
	dibujarGrid();
	
	}
	
	private void generar(int x,int y) {
		
	grid[x][y].visitado=true;
		
	 int r=StdRandom.uniform(4);
	 
	 while((!grid[x-1][y].visitado||!grid[x+1][y].visitado||!grid[x][y+1].visitado||!grid[x][y-1].visitado)) {
		 
		 
		 while(true)
		 {

			 r=StdRandom.uniform(4);
			 
			 if(validarMove(x, y, movimientos[2*r],movimientos[2*r+1])) {
				 
				 cambiarDir(x,y,r);
				 
				 generar(x+movimientos[2*r], y+movimientos[2*r+1]);
				 
				 break;
				 
				 
			 }
			 
		 }
 
	 }
	 
	}

	
	private void cambiarDir(int x,int y,int i) {
		
		if(i==0) {
			
			grid[x][y].south=!grid[x][y].south;
			grid[x+movimientos[2*i]][y+movimientos[2*i+1]].north=!grid[x+movimientos[2*i]][y+movimientos[2*i+1]].north;
		}
		
		else if(i==1) {
			
			grid[x][y].north=!grid[x][y].north;
			grid[x+movimientos[2*i]][y+movimientos[2*i+1]].south=!grid[x+movimientos[2*i]][y+movimientos[2*i+1]].south;
		
		}
		
		else if(i==3) {
			
			grid[x][y].east=!grid[x][y].east;
			grid[x+movimientos[2*i]][y+movimientos[2*i+1]].west=!grid[x+movimientos[2*i]][y+movimientos[2*i+1]].west;
			
		}
		
		else if(i==2) {
			
			grid[x][y].west=!grid[x][y].west;
			grid[x+movimientos[2*i]][y+movimientos[2*i+1]].east=!grid[x+movimientos[2*i]][y+movimientos[2*i+1]].east;
			
		}
	}
	

	private boolean validarMove(int x,int y,int movex,int movey) {

		if(!grid[x+movex][y+movey].visitado && (x+movex)>=1 && (x+movex)<=N-2 && (y+movey)>=1 && (y+movey)<=N-2)  {
			
			return true;
		}
		
		return false;
		
	}

	private  void dibujarGrid() {
		
		StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(N-1.5,N-1.5, 0.375);
        StdDraw.filledCircle(1.5, 1.5, 0.375);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int x= 1; x <N-1; x++) {
            for (int y =1; y<N-1;  y++) {
            	
            	if (grid[x][y].north) {
           
                  	StdDraw.line(y, N-x, y+1, N-x);
                  }
                  if (grid[x][y].south) {
                  	StdDraw.line(y, N-x-1, y+1, N-x-1);
                  }
                  
                  if (grid[x][y].west) {
                  	StdDraw.line(y+1, N-x, y+1, N-x-1);
                  }
                  if (grid[x][y].east) {
                  	StdDraw.line(y, N-x, y, N-x-1);
                  }
           
            }
            System.out.println();
        }
        StdDraw.show();
        StdDraw.pause(1000);
	}

	class direccion{
		
		private boolean north=true;
		private boolean south=true;
		private boolean east=true;
		private boolean west=true;
		private boolean visitado;

	}

	public static void main(String[] args) {
		
		PerfectMaze maze= new PerfectMaze(70,"s");

	}

}
