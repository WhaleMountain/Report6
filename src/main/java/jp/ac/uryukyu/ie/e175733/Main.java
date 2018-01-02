package jp.ac.uryukyu.ie.e175733;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int cnt = 1;
        boolean result = false;
        Scanner sc = new Scanner(System.in);
        QuestionNumber qs = new QuestionNumber();
        Judge ju = new Judge();
        Exception e = new Exception();

        System.out.println("数当てゲーム！！いぇーい！");
        System.out.println("ルール:4つの数がランダムに決められるため、それを10回以内に求める。");
        System.out.println("TRUE:入力された値と問題の値、位置が一緒の数");
        System.out.println("SAME:入力された値が位置は違うが問題の値が一緒の数");
        System.out.println("FALSE:入力された値が問題の値と違う数");
        System.out.println("ゲームスターート！！");

        String question = qs.setNumber();//問題の値の準備

        //ユーザー入力と判定を繰返す
        while(!result && cnt<=10){
            System.out.print(cnt+"回目の入力:");
            String user = sc.nextLine();//ユーザーの入力
            if(e.exception(user)){//例外処理
                continue;
            }
            result = ju.judge(question,user);
            cnt+=1;
        }
        //10回以内にクリアしないと負けになる
        if(cnt>=10){
            System.out.println("Your Lose...");
            System.out.println("Anser:"+question);
        }else{
            System.out.println("Your Win!!");
        }
    }
}
