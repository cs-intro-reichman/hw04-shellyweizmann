import java.util.Arrays;

public class Primes {
    public static void main(String[] args) {
       // System.out.println("boolean array");
        int n = Integer.parseInt(args[0]);
        boolean[] myArray = new boolean[n + 1];
       // System.out.println(n);
        Arrays.fill(myArray, true);
        // Print the array to verify
       // printMyArray(myArray);
        myArray[0] = false; 
        myArray[1] = false;
       // printMyArray(myArray);
        int i;
        i=0;
       /* / for(i=3; i<n+1; i++){
            if (i % 2 == 0) {
            myArray[i] = false;
            }
        }/* */
        int j;
        for(j=2; j<n+1; j++){
            i = j;
            while(i<myArray.length){
                if(i!=j){
                    myArray[i] = false;
                }
                i+=j; 
            }
            
        }
        System.out.println("Prime numbers up to " + n + ":");
        int counter = 0;
        for (i = 0; i < myArray.length; i++) {

            if (myArray[i]) { // = true
                System.out.println(i);
                counter++;
            }
        }
        double percentage =  ((double) counter / (double) n) * 100;
        
       // System.out.println(percentage);
        String formattedPercentage = String.format("%.0f", percentage);
        System.out.println("There are " + counter + " primes between 2 and " + n + " (" + formattedPercentage + "% are primes)");
        
    }
    //There are 10 primes between 2 and 30 (33% are primes)
    /*  public static void printMyArray(boolean[] boolarray) {
        for (boolean b : boolarray) {
            System.out.print(b + " ");
        }
        System.out.print("\n"); */
    }
