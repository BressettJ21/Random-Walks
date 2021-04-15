import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Walker {

	private int steps;
	private int[] startPos;
	private int[] currentPos;
	private String[] choiceArray;
	private float[] probs; 
	
    float sum(float[] array){
        
    	float sum = 0; // initialize sum
        int i;
       
        // Iterate through all elements and add them to sum
        for (i = 0; i < array.length; i++) {
           sum +=  array[i];
        }//Closes loop
        return sum;
    }//Closes Sum
    
	public void setSteps(int steps) {
		this.steps = steps;
	}//Set steps
	
	public int getSteps() {
		return this.steps;
	}//Get steps
	
	public float[] getProbs() {
		return this.probs;
	}//Closes getProbs
	
	public void showProbs() {
		System.out.println(Arrays.toString(this.getProbs()));
	}//Closes showProbs
	
	public void setProbsandChoices(float[] probs, Space space) {
		this.probs = probs;
		this.choiceArray = genChoiceArray(space.getAxis());
	}
	
	public void setRandProbs(Space space) {
		float bound = getRandValueBetween0and1();
		this.probs = new float[space.getNumAxis()];
		this.probs[0] = bound;
		 for(int i = 1; i < space.getNumAxis();i++){
			 if(i == space.getNumAxis() - 1) {
				 this.probs[i] = 1-this.sum(this.probs);
				 break;	 
			 }//Closes check last index
			 
			 else {
				 float upper = 1 - this.sum(this.probs);
				 bound = getRandValueBetween0and1()*upper;
				 this.probs[i] = bound;
				 
			}//Closes inner else
			 
		 }//Closes while loop			    
		 this.choiceArray = genChoiceArray(space.getAxis());

	}//Closes setRandProbs
	
	public void setStartPos(int[] startPos) {
		this.startPos = startPos;
		this.currentPos = this.startPos;
	
	}//Closes setStartPos
	
	public int[] getCurrentPos() {
		return this.currentPos;
	}//Closes getCurrentPos
	
	public float getRandValueBetween0and1() {
		Random rand = new Random();
		float r = rand.nextFloat();
		return r;
	}//ClosesgetRandValueBetween0and1
	
	private String[] genChoiceArray(String[] axis) {
		int new_size = 100;
		String[] new_array = new String[new_size];
		int beginLoop;
		int arrPos = 0;
		int durSum = 0;
		
		for(int i = 0; i < this.probs.length; i++) {
			int duration = Math.round(probs[i]*new_size);
			beginLoop = arrPos;
			durSum += duration;
			if (durSum == 101) duration --;
			if (durSum == 99) new_array[durSum] = axis[i];
			for(int ii = 0; ii < duration; ii ++) {
				new_array[beginLoop + ii] = axis[i];
				arrPos ++;	
			}//Closed inner loop	
		}//Closes outer loop
		return new_array;
	}//Closes genChoiceArray
	
	
	public String genChoice(String[] choiceArray) {
		int m = Math.round(getRandValueBetween0and1() * 100);
		if(m == 100) m --;
		return this.choiceArray[m];
	}//Closes getChoice

	
	public void move(Space space) {
		String choice = this.genChoice(this.choiceArray);
		System.out.println(choice);
		int index = Character.getNumericValue(choice.charAt(choice.length() - 1));		
	    if( index % 2 == 0) {
	    	if(this.currentPos[index/2] - 1 >= 0) {
	    		this.currentPos[index/2] -= 1;
		        space.incrementSpace(this.currentPos);
	    	}//Closes Check for valid movement
	    	else space.incrementSpace(this.currentPos);	
	    }//Closes Check for negative direction	       
	    else{
	    	if(this.currentPos[index/2] + 1 < space.getDim_Size()) {
	    		this.currentPos[index/2] += 1;
		        space.incrementSpace(this.currentPos);
	    	}//Closes Check for valid movement
	    	 else space.incrementSpace(this.currentPos);
	    }//Closes positive direction
	    
	}//Closes move
	
}//Close Walker Class
