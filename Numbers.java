import java.util.Scanner;
public class Numbers{
    public static void main(String[] args){
        int cnt = 1;
        boolean result = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("数当てゲーム！！いぇーい！");
        System.out.println("ルール:4つの数がランダムに決められるため、それを10回以内に求める。");
        System.out.println("TRUE:入力された値と問題の値、位置が一緒の数");
        System.out.println("SAME:入力された値が位置は違うが問題の値が一緒の数");
        System.out.println("FALSE:入力された値が問題の値と違う数");
        System.out.println("ゲームスターート！！");

        String question = setNumber();//問題の値の準備

        //ユーザー入力と判定を繰返す
        while(!result && cnt<=10){
            System.out.print(cnt+"回目の入力:");
            String user = sc.nextLine();//ユーザーの入力
            result = judge(question,user);
            cnt+=1;
        }
        //10回以内にクリアしないと負けになる
        if(cnt>=10){
            System.out.println("Your Lose...");
        }else{
            System.out.println("Your Win!!");
        }
    }

    /*
    * 問題の値とユーザー入力の値を判定する
    */
    public static boolean judge(String question, String user){
        int true_cnt=0;//入力された値と問題の値、位置が一緒の数。これが全て一緒なら勝利
        int false_cnt=0;//入力された値と問題の値が違う数
        int same_cnt=0;//入力された値と問題の値が一緒の数

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
                    if(question_num[j]==user_num[j]){
                        same_cnt-=1;//Trueのカウント文も入るためその文引く
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
        //System.out.println(question);  デバック用(答えを表示する)
        return false;
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