package jp.ac.uryukyu.ie.e175733;

public class Exception {
    /*
    * 例外処理
    * 1,入力が数字以外の時
    * 2,入力が4桁じゃない時
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
}
