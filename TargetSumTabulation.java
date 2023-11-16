import java.util.*;
public class TargetSumTabulation{
    public static boolean TargetSum(int arr[] , int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];


        // here i: number of items , and j: is the sum


        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }//when sum = 0 , then the index would store true for any number of items (numbers)

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];

                //include
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }
    public static void main(String args[]){
        int arr[] = {4,2,7,1,3};
        int targetSum = 10;

        System.out.println(TargetSum(arr, targetSum));
    }
}

//the time complexity of this code is O(n*sum)