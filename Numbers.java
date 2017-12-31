public class Numbers{
    public static void main(String[] args){
        int[] num = new int[4];//問題の値を代入する変数
        for(int i=0;i<4;i++){
            num[i] = (int)(Math.random()*9)+1;//1~9の間でランダムに代入する
        }
    }
}