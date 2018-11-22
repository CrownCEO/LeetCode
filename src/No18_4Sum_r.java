import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四个数的和 递归版本
 *
 * @author Mr.Bao
 * @create 2018-10-15-21:08
 * @since 1.0.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class No18_4Sum_r
{
    /*
     * 通过吧KSum降低为K-1Sum，然后逐步降低，最后处理2Sum
     *
     * */
    public List<List<Integer>> fourSumBBBB(int[] nums, int target)
    {
        Arrays.sort(nums);
        return kSum(nums, target, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target,int kSum)
    {
        List<Integer> one=new ArrayList<>();
        kSumByDG(kSum, nums, 0, nums.length-kSum+1, target, one);
        return finResList;
    }

    public void kSumByDG(int kSum,int[] nums,int beg ,int end,int target,List<Integer> one)
    {
        if(kSum==2)
        {
            int allSum=0;
            for(int i=0;i<one.size();i++)
                allSum+=one.get(i);
            int left=beg,right=end;
            while(left < right)
            {
                int ssum = allSum + nums[left]+nums[right];
                if(ssum==target)
                {
                    List<Integer> tmp = new ArrayList<>(one);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    finResList.add(tmp);
                    while(left < right && nums[left]==nums[left+1]) left++;
                    while(left < right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(ssum < target)
                    left++;
                else
                    right--;
            }
            return ;
        }else
        {
            for(int i=beg;i<end;i++)
            {
                if(i!=beg && nums[i]==nums[i-1]) {
                    continue;
                }
                if( i+1 < end+1)
                {
                    one.add(nums[i]);
                    kSumByDG(kSum-1, nums, i+1, end+1, target, one);
                    one.remove(one.size()-1);
                }
            }
        }
    }

    /*
     * 通过循环，来实现，和上面通过递归实现的本质是一样的。
     * */
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> finResList=new ArrayList<>();
        if(nums==null ||nums.length<4)
            return finResList;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int beg=j+1;
                int end=nums.length-1;
                while(beg < end)
                {
                    int sum = nums[i] + nums[j] + nums[beg] + nums[end];
                    if(sum==target)
                    {
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[beg]);
                        t.add(nums[end]);
                        finResList.add(t);
                        while(beg<end && nums[beg+1]==nums[beg])
                            beg++;
                        while(beg<end && nums[end-1]==nums[end])
                            end--;
                        beg++;
                        end--;
                    }else if(sum < target)
                        beg++;
                    else
                        end--;
                }
            }
        }
        return finResList;
    }

    HashMap<Integer, List<List<Integer>>> map=new HashMap<>();
    List<List<Integer>> finResList=new ArrayList<>();
    List<List<Integer>> finIndexList=new ArrayList<>();

    //使用hash需靠考虑的细节实在是太多了，下面的方法并不能覆盖所有情况
    public List<List<Integer>> fourSumWithHash(int[] nums, int target)
    {
        Arrays.sort(nums);
        if(nums==null || nums.length<4)
            return finResList;
        else if(nums.length==4)
        {
            int sum=0;
            List<Integer> tt=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                tt.add(nums[i]);
                sum+=nums[i];
            }
            if(sum==target)
                finResList.add(tt);
            return finResList;
        }

        for(int i=0;i<nums.length;i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                int sum=nums[i] + nums[j];
                List<Integer> tmp=new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                List<List<Integer>> res=map.get(sum);
                if(res==null)
                {
                    res=new ArrayList<>();
                    map.put(sum, res);
                }
                map.get(sum).add(tmp);
            }
        }

        List<Integer> key=new ArrayList<>(map.keySet());
        key.sort(null);
        int left=0,right=key.size()-1;
        while(left <= right)
        {
            int sum=key.get(left) + key.get(right);
            if(sum==target)
            {
                List<List<Integer>> res1=map.get(key.get(left));
                List<List<Integer>> res2=map.get(key.get(right));
                for (int j = 0; j < res1.size(); j++)
                {
                    for (int k = 0; k < res2.size(); k++)
                    {
                        AddOne(res1.get(j),res2.get(k));
                    }
                }
                left++;
                right--;

            }else if(sum < target)
                left++;
            else
                right--;
        }
        return finResList;

    }

    public void AddOne(List<Integer> a,List<Integer> b)
    {
        Set<Integer> set=new HashSet<Integer>();
        set.add(a.get(0));
        set.add(a.get(1));
        set.add(b.get(0));
        set.add(b.get(1));
        if(set.size()<4)
            return ;

        List<Integer> index=new ArrayList<>(set);
        index.sort(null);
        boolean need=true;

        /*
         * 重复添加问题的解决，先判断index的重复
         * */
        for(int i=0;i<finIndexList.size();i++)
        {
            List<Integer> tt=finIndexList.get(i);
            if(tt.get(0)==index.get(0) && tt.get(1)==index.get(1) && tt.get(2)==index.get(2) && tt.get(3)==index.get(3))
            {
                need=false;
                break;
            }
        }
        if(need)
        {
            List<Integer> res=new ArrayList<>();
            res.add(a.get(2));
            res.add(a.get(3));
            res.add(b.get(2));
            res.add(b.get(3));
            res.sort(null);
            boolean sub=true;

            //index不重复的前提下考虑，具体数值的重复
            for(int i=0;i<finResList.size();i++)
            {
                List<Integer> tt=finResList.get(i);
                if(tt.get(0)==res.get(0) && tt.get(1)==res.get(1) && tt.get(2)==res.get(2) && tt.get(3)==res.get(3))
                {
                    sub=false;
                    break;
                }
            }
            if(sub)
                finResList.add(res);
        }
    }


    public static void main(String[] args)
    {
        No18_4Sum_r so=new No18_4Sum_r();
        int []nums={1, 0, -1, 0, -2, 2};
        System.out.println(so.fourSumBBBB(nums, 0));
    }
}

