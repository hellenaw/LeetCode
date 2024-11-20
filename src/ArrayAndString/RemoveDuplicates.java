
import java.util.Arrays;


class RemoveDuplicates{

    public static int removeDuplicates(int[] nums){

        // if(nums.length == 0){
        //     return 0;
        // }
        
        // List<Integer> uniqueList = new ArrayList<>();



        // for(int i = 0; i < nums.length; i++){
        //     if(!uniqueList.contains(nums[i])){
        //         uniqueList.add(nums[i]);
        //     }
        // }

        // int k = uniqueList.size();


        // for(int i = 0; i < nums.length; i++){
        //     if (i < k){
        //         nums[i] = uniqueList.get(i);
        //     }else{
        //         nums[i] = 0;
        //     }
        // }
        // System.out.println(Arrays.toString(nums));
        // return k;


        int k = 0;
        for(int element : nums){
            if(element != nums[k]){
                k++;
                nums[k] = element;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        return k + 1;
    }
    
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}