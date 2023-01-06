package Microsoft;

import java.util.*;
public class Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        if(nums==null||nums.length==0)
        {
            return Collections.<Integer>emptyList();
        }
        if(nums.length==1)
        {
            List<Integer> ls=new ArrayList<Integer>(1);
            ls.add(nums[0]);
            return ls;
        }
        Arrays.sort(nums);

        HashMap<Integer,List<Integer>> mp=new HashMap<Integer,List<Integer>>();
        List<Integer> maxSubset=null;
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> ls=null;
            if(!mp.containsKey(i))
            {
                ls=dfs(i,nums,mp);


            }else
            {
                ls=mp.get(i);
            }

            if(maxSubset==null||ls.size()>maxSubset.size())
            {
                maxSubset=ls;
            }
        }
        return maxSubset;
    }

    private List<Integer> dfs(int idx, int[] arr,HashMap<Integer,List<Integer>> mp)
    {
        if(mp.containsKey(idx))
        {
            return mp.get(idx);
        }
        List<Integer> ls=new ArrayList<Integer>();

        for(int i=idx+1;i<arr.length;i++)
        {
            if((arr[i]%arr[idx])==0)
            {
                List<Integer> r=dfs(i,arr,mp);
                if(r.size()>ls.size())
                {
                    ls=r;
                }

            }
        }

        ls=new ArrayList<Integer>(ls);
        ls.add(0,arr[idx]);
        mp.put(idx,ls);
        return ls;

    }
}
