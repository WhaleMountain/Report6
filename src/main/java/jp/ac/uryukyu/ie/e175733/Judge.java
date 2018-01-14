package jp.ac.uryukyu.ie.e175733;

public class Judge {
    /*
    * 問題の値とユーザー入力の値を判定する
    */

    private int true_cnt=0;//入力された値と問題の値、位置が一緒の数。これが全て一緒なら勝利
    private int false_cnt=0;//入力された値と問題の値が違う数
    private int same_cnt=0;//入力された値と問題の値が一緒の数

    public boolean judge(String question, String user){
        char[] question_num = question.toCharArray();//判定をしやすいよう一文字づつに区切る
        char[] user_num = user.toCharArray();//判定しやすいよう一文字づつに区切る

        //第一判定 True,Falseの数を求める
        for(int i=0;i<4;i++){
            if(question_num[i]==user_num[i]){
                true_cnt+=1;//入力された値、位置が一緒の数
            }else{
                false_cnt+=1;//入力された値が間違っている数
            }
        }

        //第二判定 Sameの数を求める
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(question_num[i]==user_num[j]){
                    same_cnt+=1;//位置に関係なく同じ値の数
                    if(question_num[i]==user_num[i]){
                        same_cnt-=1;//同じ数をカウントしない
                    }
                    break;
                }
            }
        }

        System.out.println("TRUE:"+true_cnt+" SAME:"+same_cnt+" FALSE:"+(false_cnt-same_cnt));//第一判定のfalseではsameの値もカウントしているため引き算をする
        if(true_cnt==4){//全ての値と位置が正解したら勝利になる
            return true;
        }
        true_cnt=0;
        false_cnt=0;
        same_cnt=0;
        return false;
    }
}