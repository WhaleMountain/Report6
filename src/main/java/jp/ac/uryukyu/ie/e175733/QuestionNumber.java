package jp.ac.uryukyu.ie.e175733;

public class QuestionNumber {
    /*
    * 重複が限りなく少ない問題の値を生成する
    * 文字列にした方が返り値として利用しやすいため文字列に変換している
    */

    private int[] num = new int[4];//問題の値を代入する変数
    private int[] tmp = new int[4];//同じ数があるかの判定に使う
    private String question_num = "";

    public String setNumber(){
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
    private int randNumber(){
        int number = (int)(Math.random()*9)+1;
        return number;
    }
}