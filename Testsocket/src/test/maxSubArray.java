package test;

public class maxSubArray {

    public int maxSubArray(int[] nums){

        int sum = nums[0];
        int n = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if (n > 0 ){
                n += nums[i];
            }else {
                n = nums[i];
            }
            if (sum < n){
                sum = n;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        maxSubArray maxSubArray = new maxSubArray();
        int max = maxSubArray.maxSubArray(nums);
        System.out.println(max);
    }
}
