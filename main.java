import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		
		int numDims = 2;
		int dimLength = 10;
		int steps = 50;
		int startPos[] = {5,5,5};	// Make sure len = numDims 
		
		Space space = new Space(numDims,dimLength);
		
		Walker walker1 = new Walker();
		
		
		walker1.setStartPos(startPos);
		
		//float probsList[] =  {.25f,.25f,.25f,.25f};
		//walker1.setProbs(probsList, space);
		
		walker1.setRandProbs(space);
		
		walker1.setSteps(steps);
		
		final long startTime = System.currentTimeMillis();
		
		
		for(int i = 0; i < walker1.getSteps();i++) {
			walker1.move(space);
		}
		
		
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		
		walker1.showProbs();
		space.showSpace();


	}//Close Main method

}//Close main class
