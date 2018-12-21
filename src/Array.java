//         COSC 1337.S01
//         Lab 6
//         2015/4/21
//         Array.java
//---------------------------------------------------------------
import java.util.Scanner;
public class Array { 
    public static void main(String[] args) { 
        double max = 0;
        double min = 0;
        double average = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the total number of integer elements to be"
                + " placed into the array");
        Integer sizeOfArray = keyboard.nextInt();
        double[] array = new double[sizeOfArray];
            System.out.println("So "+sizeOfArray+" is the size of the array");
            System.out.println("Now enter "+sizeOfArray+" unique intgers "
                    + "(negative or positive)");
        for (int index=0; index<sizeOfArray;index++){
            array[index]=keyboard.nextInt();
            System.out.println("You entered "+array[index]);
        }
        
        System.out.println("Printed Array");  
        printArray(array);
        
        sort(array, sizeOfArray);
        System.out.println("Sorted Array");
        printArray(array);
        
        max=getHighest(max, sizeOfArray, array);
        System.out.println("Highest Value");
        System.out.println(max);
        
        min=getLowest(min, sizeOfArray, array);
        System.out.println("Lowest Value");
        System.out.println(min);
        
        average=getAverage(average,sizeOfArray,array);
        System.out.println("Average Value");
        System.out.println(average);
    }   
    
    public static void sort(double[] a, int numberUsed){
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed-1; index++){
            indexOfNextSmallest=indexOfSmallest(index, a, numberUsed);
            interchange(index,indexOfNextSmallest, a);
        }
    }
    
    private static int indexOfSmallest(int startIndex,double[]a,int numberUsed){
        double min = a[startIndex];
        int indexOfMin = startIndex;
        int index;
        for(index = startIndex+1;index<numberUsed;index++)
            if (a[index] < min){
                min = a[index];
                indexOfMin = index;
            }
           return indexOfMin;
    }
    
    private static void interchange (int i, int j, double[] a){
        double temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static double getHighest(double max, int numberUsed, double[]a){
        max=a[0];
        for (int i=0;i<a.length;i++){
            if (a[i]>max)
                max=a[i];
        }
        return max;
    }
    
    public static double getLowest(double min, int numberUsed, double[]a){
        min=a[0];
        for (int i=0;i<a.length;i++){
            if (a[i]<min)
                min=a[i];
        }
        return min;
    }
    
    public static double getAverage(double average, int numberUsed, double a[]){
        double total = 0; 
        for (int i=0;i<a.length;i++){
        total+=a[i];     
        }  
        average=total/numberUsed;
        return average;
    }
    
    public static void printArray(double[]a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }   
        System.out.println(); 
    } 
}