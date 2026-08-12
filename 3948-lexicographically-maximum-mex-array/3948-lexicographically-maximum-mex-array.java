import java.util.*;

class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq=new HashMap<>();
        for(int x: nums){
            freq.put(x,freq.getOrDefault(x, 0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<n)
            {
                int mex=0;
                while(freq.getOrDefault(mex,0)>0){
                    mex++;
                }
                if (mex==0)
                {
                    ans.add(0);
                    freq.put(nums[i],freq.get(nums[i])-1);
                    if (freq.get(nums[i])==0){
                        freq.remove(nums[i]);
                        
                    }
                    i++;
                    continue;
                }
                Set<Integer> need = new HashSet<>();
            for (int x = 0; x < mex; x++) {
                need.add(x);
            }

            int j = i;

            while (!need.isEmpty()) {
                int val = nums[j];

                freq.put(val, freq.get(val) - 1);
                if (freq.get(val) == 0) {
                    freq.remove(val);
                }

                need.remove(val);
                j++;
            }

            ans.add(mex);
            i = j;
        }

        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }

        return res;
                
            
        
    }
}