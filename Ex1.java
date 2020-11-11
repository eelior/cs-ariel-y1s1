import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		// take the absolute value of two integers input from the user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input1 = Math.abs(scan.nextInt());
        System.out.print("Enter another number: ");
        int input2 = Math.abs(scan.nextInt());
        scan.close();        
        
        // check which one is bigger
        int highNum = 0;
        int lowNum = 0;
        if (input1 > input2) {
        	highNum = input1;
        	lowNum = input2;
        } else {
        	highNum = input2;
        	lowNum = input1;
        }
        
        // set initial GCD
        int gcd = 1;
        
        // if none of the inputs is 1
        if (highNum != 1 && lowNum != 1) {
        	// start tests from the top of the lower input, first looping looking for an integer that is a divider
            for (int di = lowNum; di > 1; di--) {
            	// if it is a divider, start test to check if it is a prime number
            	if (lowNum%di == 0) {
            		// assuming it is and trying to break that assumption
            		boolean isComposite = false;
            		// starting from 2 and up check weather it divides in any number else then itself and 1
            		for (int pi = 2; pi < di; pi++) {
            			if (di%pi == 0) {
            				// change the assumption variable indicator and break the test loop
            				isComposite = true;
            				pi = di;
            			}
            		}
            		// if our assumption appears to be true, we check if it is a divider of highNum too.  
            		if (!isComposite && highNum%di == 0) {
            			// if it is, set it as the new GCD and stop the test.
            			gcd = di;
            			break;
            		}
            	}
            	
            }

        }
        
        System.out.println("The prime GCD of the user inputs is: "+gcd);
	}

}
