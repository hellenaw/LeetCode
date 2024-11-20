import java.util.Arrays;

class RemoveElement{

    public static int removeElement(int[] nums, int val){

        int k = 0;
        for(int element : nums){
            if(element != val){
                nums[k] = element;
                k++;
            }
        }
        return k;
       
    }

    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

}