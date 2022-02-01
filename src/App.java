import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class App {
    public static void main(String[] args) throws Exception {
        int[] testingArrays = {3,5,-4,8,11,1,-1,6};
        int[] testingArrays2 = {11,8,1,3,5,6,-1,-4};
        int testingTarget = 10;
        int testingTarget2 = 13;

        twoNumberSum1(testingArrays, testingTarget);
        twoNumberSum2(testingArrays, testingTarget);
        twoNumberSum3(testingArrays2, testingTarget2);
    }

    //This is the double for loop.
    //O(n^2) time | O(1) space
    //This is the testing message from pc.
    //This is the testing message from mac. 
    public static int[] twoNumberSum1(int[] randomArray, int targetNumber){
        
        for(int i=0; i<randomArray.length-1; i++){
            int firstNumber = randomArray[i];
            for(int j=i+1;j<randomArray.length;j++){
                int secondNumber = randomArray[j];
                if(firstNumber+secondNumber==targetNumber){
                    int[] results = {firstNumber,secondNumber};
                    System.out.println("twoNumberSum1 test result: Match found--"+Arrays.toString(results));
                    return results;
                }
            }
        }
        System.out.println("twoNumberSum1 test result: Match not found");
        return new int[0];
    }

    //Using HastSet to store the protential matches.
    public static int[] twoNumberSum2(int[] randomArray, int targetNumber){

        Set<Integer> storedNums = new HashSet<Integer>();
        
        for(int num:randomArray){
            int protentialMatch=targetNumber-num;
            if(storedNums.contains(protentialMatch)){
                int[] results={protentialMatch,num};
                System.out.println("twoNumberSum2 test result: Match found-- "+Arrays.toString(results));
                return results;
            }else{
                storedNums.add(num); //No luck, store the num into HashSet.
            }
        }
        System.out.println("twoNumberSum2 test result: Match not found....");
        return new int[0];
    }

    //Using left and right pointers to get the result.
    public static int[] twoNumberSum3(int[] randomArray, int targetNumber){
        Arrays.sort(randomArray);
        System.out.println("Input arrays sorted: " + Arrays.toString(randomArray));

        int leftPointer = 0;
        int rightPointer = randomArray.length-1;

        while(leftPointer<rightPointer){
            int currentSum=randomArray[leftPointer]+randomArray[rightPointer];
            System.out.println("currentSum: " + currentSum);
            if(currentSum==targetNumber){
                int[] result = {randomArray[leftPointer],randomArray[rightPointer]};
                System.out.println("twoNumberSum3 test result: Match found-- "+Arrays.toString(result));
                return result;
            }else if(currentSum<targetNumber){
                leftPointer++;
            }else if(currentSum>targetNumber){
                rightPointer--;
            }
        }
        System.out.println("twoNumberSum3 test result: Match not found.");
        return new int[0];
    }
}
