public class Kmp {
    /*
    @func 构建前缀表
    @param pattern:匹配字符数组,prefix：前缀表,n匹配字符数据的长度
     */
    public static void prefix_table(char[] pattern,int[] prefix,int n){
        prefix[0] =0;//前缀表第一个初始为0
        int len =0;//len为前缀值，从0开始
        int i =1;//从第一个开始
        while(i<n){
            if(pattern[i]==pattern[len]){//当前字符与前缀值相同
                len++;
                prefix[i]=len;
                i++;
            }else{//当前字符与前缀值相同不同
                if(len>0)
                    len=prefix[len-1];//左下移动，直到前缀值等于0
                else{
                    prefix[i]=len;//前缀值为0,赋值给当前i的前缀值
                    i++;//i右移
                }
            }
        }
    }
    /*
    @func 完成前缀表的构建
     */
    public static void move_table(int[] prefix){
        int len=prefix.length;
        for(int i=len-1;i>0;i--)
        {
            prefix[i]=prefix[i-1];
        }
        prefix[0]=-1;
    }

    public static void main(String[] args) {
        String pattern ="ABABCABAA";
        int[] prefix = new int[9];
        int n=9;
        prefix_table(pattern.toCharArray(), prefix,n );
        move_table(prefix);
        for(int i:prefix)
            System.out.print(i+"、");

    }
}
