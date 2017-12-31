import java.util.Scanner;
public class Numbers{
    public static void main(String[] args){
        int true_cnt=0;//入力された値と問題の値、位置が一緒の数。これが全て一緒なら勝利
        int false_cnt=0;//入力された値と問題の値が違う数
        int same_cnt=0;//入力された値と問題の値が一緒の数
        Scanner sc = new Scanner(System.in);
        String question = setNumber();//問題の値の準備
        char[] question_num = question.toCharArray();//判定をしやすいよう一文字づつに区切る
        
        String user = sc.nextLine();//ユーザーの入力
        char[] user_num = user.toCharArray();//判定しやすいよう一文字づつに区切る

        //第一判定 True,Falseの数を求める
        for(int i=0;i<4;i++){
            if(what_num[i]==user_num[i]){
                true_cnt+=1;//入力された値、位置が一緒の数
            }else{
                false_cnt+=1;//入力された値が間違っている数
            }
        }

        //第二判定 Sameの数を求める
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(what_num[i]==user_num[j]){
                    same_cnt+=1;//位置に関係なく同じ値の数
                    if(what_num[j]==user_num[j]){
                        same_cnt-=1;//Trueのカウント文も入るためその文引く
                    }
                    break;
                }
            }
        }

    }

    /*
    * 重複が限りなく少ない問題の値を生成する
    * 文字列にした方が返り値として利用しやすいため文字列に変換している
    */
    public static String setNumber(){
        int[] num = new int[4];//問題の値を代入する変数
        int[] tmp = new int[4];//同じ数があるかの判定に使う
        String question_num = "";

        for(int i=0;i<4;i++){
            num[i] = randNumber();//1~9の間でランダムに代入する
            tmp[i] = num[i];
            for(int j=1;j<=i;j++){
                if(num[i]==tmp[j-1]){//問題の値に同じ値があるか判断する
                    if(num[i]>=7){//7~9の値が被っていたら引き算をする
                        num[i] -= j;
                    }else{        //それ以外が被っている場合には足し算をする
                        num[i] += j;
                    }
                    tmp[i] = num[i];
                }
            }
        }

        //生成した値を文字列に変換
        for(int i=0;i<4;i++){
            question_num += String.valueOf(num[i]);
        }

        return question_num;
    }

    /*
    * ランダムに値を生成する
    */
    public static int randNumber(){
        int number = (int)(Math.random()*9)+1;
        return number;
    }

}