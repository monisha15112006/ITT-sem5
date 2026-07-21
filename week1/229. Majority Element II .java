class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> m=new HashMap();
        List<Integer> result=new ArrayList();
        int count;
       /* for(int i=0;i<nums.length;i++){
            if(!m.containsKey(nums[i])){
                count=0;
                for(int j=i;j<nums.length;j++){
                    if(nums[i]==nums[j]) count++;
                }
                m.put(nums[i],count);
            }
        }
        */
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        long thres=nums.length/3;
        for(int key:m.keySet()){
            if(m.get(key)>thres)result.add(key);
        }
        return result;
    }
}
