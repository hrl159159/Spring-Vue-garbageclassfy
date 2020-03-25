package com.hrl.gagbageclassfy.Entity;

import lombok.Data;

//选择题实体类
@Data
public class MultiQuestion {
    private String subject;
    private Integer questionId;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String rightAnswer;
    private Integer score;
    private String level;
    private String section;
    private String analysis;
}
