import java.util.*;

public class MyMain {

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) { 
        //this is to keep track of total number of items
        int counting=0;
        //count track of cumulative value
        double total = 0;
        //this is to find number of rows
        for(int i=0;i<mat.length;i++){
            //to find number of columns
            for(int j=0;j<mat[i].length;j++){
                total = total + mat[i][j];
                counting++;
            }
        }
        double x = total / counting;
        return x;
        // YOUR CODE HERE
        //return -1.0;
    }

    // Returns the median of the 2D array mat
    public static double median(double[][] mat) {
        //finding amount of columns
        int x1 = mat[0].length;
        //finding amount of rows
        int x2 = mat.length;
        //counting is the total # of items
        int counting = x1 * x2;
        //making a singular array that can be manipulated
        double[] arr = new double[counting];

        //copying values into arraylist
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) { 
                list.add(mat[i][j]); 
            }
        }
        //test printing
        //System.out.println(list);
        
        //adding items from arraylist to the double array
        for (int i = 0; i < counting; i++) {
            double str = list.get(i);
            arr[i] = str;
            
        }

        //code to find the mean
        //sort method seen in a youtube video but was helpful in this case
        Arrays.sort(arr);
        //int[] arr = mat[0];
        if (arr.length % 2 != 0) 
            return (double)arr[arr.length / 2]; 
  
        return (double)(arr[(arr.length - 1) / 2] + arr[arr.length / 2]) / 2.0; 
    }
    

    // Returns the mode of the 2D array mat
    public static double mode(double[][] mat) { 
        
        //getting it into one array, same code as median
        int x1 = mat[0].length;
        int x2 = mat.length;
        int counting = x1 * x2;
        double[] arr = new double[counting];

        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) { 
                list.add(mat[i][j]); 
            }
        }
        for (int i = 0; i < counting; i++) {
            double str = list.get(i);
            arr[i] = str;
        }

        //code to find the mode
        //making 2 doubles that will be used later
        double VV = 0;
        double max = 0;
        //compares values seeing if anything appears more than once
        for (int x = 0; x < arr.length; x++) {
            int count = 0;
            for (int y = 0; y < arr.length; y++) {
                if (arr[y] == arr[x])
                count++;
            }

            if (count > max) {
                max = count;
                VV = arr[x];
            }
        }
        //returning one that occurs the most
        return VV;
         
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
        double[][] mat2 = { {4, 2, 6},
                     {8, 0, 10},
                     {7, 1, 5} };  

        System.out.println(mean(mat2));
        System.out.println(median(mat2));
        System.out.println(mode(mat2));
    }
}
