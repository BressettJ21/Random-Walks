import java.util.Arrays;

public class Space {
	
	private int num_dimensions;
	//unused because only doing 1D first
	private int dim_size;
	
	private int A1[];
	private int A2[][];
	private int A3[][][];
	private String[] axis;
	
	public Space(int num_dimensions, int dim_size) {
		this.num_dimensions = num_dimensions;	//Placeholder for higher dimensional walks
		this.dim_size = dim_size;
		
		switch(this.num_dimensions) {
		  case 1:
			  this.A1 = new int[this.dim_size];
		    break;
		  case 2:
			  this.A2 = new int[this.dim_size][this.dim_size];
		    break;
		  case 3:
			  this.A3 = new int[this.dim_size][this.dim_size][this.dim_size];
			    break;

		}//Closes Switch
		genAxis();
	}//Closes Space constructor
	
	private void genAxis() {
		this.axis = new String[this.getNumAxis()];
		
		for(int i = 0;i < this.getNumAxis();i++) {
			this.axis[i] = "Axis" + i;
		}//Closes for Loop
	}//Closes getAxisList
	
	public String[] getAxis(){
		return this.axis;
	}//Closes get Axis
	
	
	public int getDim_Size() {
		return this.dim_size;
	}
	public int getNumAxis() {
		return this.num_dimensions * 2;
	}
	
	public int getNum_Dims() {
		return this.num_dimensions;
	}
	
	public void showSpace() {
		switch(this.num_dimensions) {
		  case 1:
				System.out.println(Arrays.toString(this.A1));
		    break;
		  case 2:
				for(int i = 0;i<this.A2.length;i++) {
					System.out.println(Arrays.toString(this.A2[i]));
				}
		    break;
		  case 3:
			  for(int i = 0;i<this.A3.length;i++) {
				  for(int j = 0; j<this.A3.length;j++) {
					  System.out.println(Arrays.toString(this.A3[i][j]));  
				  }
			  }
				break;
		}//Closes Switch
	}//Closes Show space
	
	
	
	public Space incrementSpace(int[] index) {
		switch(this.num_dimensions) {
		  case 1:
			  this.A1[index[0]] ++;
		    break;
		  case 2:
			  this.A2[index[0]][index[1]] ++;
		    break;
		  case 3:
			  this.A3[index[0]][index[1]][index[2]] ++;
			    break;
		}//Closes Switch
		return this;
	}//Closes increment Space
	
	
}//Closes Space
