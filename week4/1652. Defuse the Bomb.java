class Solution {
    public int[] decrypt(int[] code, int k) {
        int res[]=new int[code.length];
        int n=code.length,j,count,sum=0;
        if(k==0) return res;
        if(k<0){
            for(int i=0;i<n;i++){
                j = (i == 0) ? n - 1 : i - 1; 
                sum=0;
                count=k*-1;
                while(count>0){
                    sum+=code[j];
                    count--;
                    j=(j==0) ? n-1:j-1;
                }
                res[i]=sum;

            }
        }
         if(k>0){
            for(int i=0;i<n;i++){
                j = (i == n - 1) ? 0 : i + 1;

                sum=0;
                count=k;
                while(count>0){
                    sum+=code[j];
                    count--;
                    j=(j==n-1) ? 0:j+1;
                }
                res[i]=sum;
            }
        }
        return res;
    }
}
