package Microsoft;

import java.util.*;

public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> uwu=new ArrayList<>();
        combination(uwu,new ArrayList<>(),k,1,n);
        return uwu;
    }

    public void combination(List<List<Integer>> uwu,List<Integer> oni,int k, int s,int n)
    {
        if(oni.size()==k && n==0 )
        {
            List<Integer> li=new ArrayList<>(oni);
            uwu.add(li);
            return;
        }
        for(int i=s;i<=9;i++)
        {
            oni.add(i);
            combination(uwu,oni,k,i+1,n-i);
            oni.remove(oni.size()-1);
        }
    }
}
