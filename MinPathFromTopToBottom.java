class Solution {
    
    int min;
    public int minimumTotal(List<List<Integer>> triangle) {
        min=Integer.MAX_VALUE;
        if(triangle.size()==1)
        {
            return triangle.get(0).get(0);
        }
        min =cost(triangle,0,1,triangle.size()-1);
        return min+triangle.get(0).get(0);
    }
    int cost(List<List<Integer>> triangle,int cIndex,int rowNo,int noRows)
    {
        if(rowNo==noRows)
        {
            List<Integer> list=triangle.get(rowNo);
            return Math.min(list.get(cIndex),list.get(cIndex+1));
        }
        List<Integer> list=triangle.get(rowNo);
        int left=0;
        for(int i=cIndex;i<cIndex+2 && cIndex == 0 ;i++)
        {
            left=cost(triangle,i,rowNo+1,noRows);
            // System.out.println(list.get(i)+" "+i+" "+left+" "+rowNo+" ");
            list.set(i,left+list.get(i));
        }
        for(int i=cIndex+1;i<cIndex+2 &&  cIndex != 0  ;i++)
        {
            left=cost(triangle,i,rowNo+1,noRows);
            // System.out.println(list.get(i)+" "+i+" "+left+" "+rowNo+" ");
            list.set(i,left+list.get(i));
        }
        return Math.min(list.get(cIndex),list.get(cIndex+1));
    }
}
