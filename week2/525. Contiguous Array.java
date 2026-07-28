class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int sum=0;
        int mlen=0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }
            else{
                sum+=1;
            }
            if(mp.containsKey(sum)){
                 int ind=i-mp.get(sum);
                 mlen=Math.max(mlen,ind);
            }
            else{
                mp.put(sum,i);
            }

        }
        return mlen;
    }
}
