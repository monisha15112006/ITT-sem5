class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int i,next;
             int[] result = new int[nums.length];
      
        for(i=0;i<nums.length;i++){
              boolean found=false;
            int n=nums[i];
            int count=nums.length-1;
            next=(i==nums.length-1)?0:i+1;
            while(count!=0){
       
            if(nums[next]>nums[i]) {result[i]=nums[next];found=true;break;}
            next=(next==nums.length-1)?0:next+1;
            count--;}
            if(!found)result[i]=-1;
            
    }    return result;
    }
}
