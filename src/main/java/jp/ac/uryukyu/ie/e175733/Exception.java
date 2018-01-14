package jp.ac.uryukyu.ie.e175733;

public class Exception {
    /*
    * 例外処理
    * 1,入力が数字以外の時
    * 2,入力が4桁じゃない時
    * どちらか1つが当てはまるともう一度入力を施す
    */
    public boolean exception(String user){
        try{//数字以外が入力されている場合の例外処理
            int i = Integer.parseInt(user);
        }catch(NumberFormatException e){
            System.out.println("数字を入力してください");
            return true;
        }
        if(user.length()>4 || user.length()<4){//4桁以内、4桁以上で入力されていないか
            System.out.println("4桁で入力してください");
            return true;
        }
        return false;
    }

    /*
    * 最終重複確認
    * 問題の値が重複していないか確認する
    */
    public boolean overlap(String question){
        char[] q = question.toCharArray();
        for(int i=0;i<3;i++){
            for(int j=(i+1);j<4;j++){
                if(q[i]==q[j]){
                    return true;
                }
            }
        }
        return false;
    }

}