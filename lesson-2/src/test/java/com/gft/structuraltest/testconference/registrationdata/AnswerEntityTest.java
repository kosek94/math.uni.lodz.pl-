package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;
import org.junit.*;

public class AnswerEntityTest{

    @Test
    public void shouldReturnFalseWhenObjectIsNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = null;
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnTrueWhenObjectEqualsObject(){
        AnswerEntity an1 = new AnswerEntity();
        assertTrue(an1.equals(an1));
    }
    
    @Test
    public void shouldReturnFalseWhenObjectClassNotEqualsAnotherObjectClass(){
        AnswerEntity an1 = new AnswerEntity();
        Object an2 = new Object();
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectTextIsNullAndTheOtherIsNotNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setAnswerText("Answer");
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectTextAndSecondObjectTextAreNotEqual(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setAnswerText("Answer1");
        an2.setAnswerText("Answer2");
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectIdIsNullAndSecondObjectIdIsNotNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setId(1L);
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectIdAndSecondObjectIdAreNotEqual(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an1.setId(1L);
        an2.setId(2L);
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectQuestionIsNullAndSecondObjectQuestionIsNotNull(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        an2.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnFalseWhenFirstObjectQuestionAndSecondQuestionAreNotEqual(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        QuestionEntity question = new QuestionEntity();
        question.setId(1L);
        an1.setQuestion(question);
        an2.setQuestion(new QuestionEntity());
        assertFalse(an1.equals(an2));
    }
    
    @Test
    public void shouldReturnTrueWhenTwoObjectsAreEqual(){
        AnswerEntity an1 = new AnswerEntity();
        AnswerEntity an2 = new AnswerEntity();
        assertTrue(an1.equals(an2));
    }
    
}