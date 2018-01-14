package jp.ac.uryukyu.ie.e175733;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionNumberTest {
    @Test
    /**
     * 同じ値がある場合にtrueを返すか
     */
    void setNumber() {
        Exception e = new Exception();
        boolean result =e .overlap("1134");
        assertEquals(true,result);

    }

}