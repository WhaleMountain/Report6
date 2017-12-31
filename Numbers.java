public class Numbers{
    public static void main(String[] args){
        int[] num = new int[4];//問題の値を代入する変数
        int[] tmp = new int[4];//同じ数があるかの判定に使う
        for(int i=0;i<4;i++){
            num[i] = (int)(Math.random()*9)+1;//1~9の間でランダムに代入する
            tmp[i] = num[i];
            for(int j=1;j<=i;j++){
                if(num[i]==tmp[j-1]){//問題の値に同じ値があるか判断する
                    num[i] = (int)(Math.random()*9)+1;//同じ値がある場合もう一度ランダムに代入する
                    tmp[i] = num[i];
                }
            }
        }
    }
}