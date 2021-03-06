package com.hrl.gagbageclassfy.Entity;

import lombok.Data;

//判断题实体类
@Data
public class JudgeQuestion {
    private String subject;
    private Integer questionId;
    private String question;
    private String answer;
    private Integer score;
    private String level;
    private String section;
    private String analysis;
}
