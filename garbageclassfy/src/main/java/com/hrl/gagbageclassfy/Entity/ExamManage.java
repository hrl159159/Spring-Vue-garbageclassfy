package com.hrl.gagbageclassfy.Entity;

import lombok.Data;

import java.util.Date;


/**
 * 使用lombok的注解@Data，可以帮我们省去getter()和setter()方法的代码，
 * 让代码更简洁
 */
@Data
public class ExamManage {
    private Integer examCode;

    private String description;

    private String source;

    private Integer paperId;

    private Date examDate;

    private Integer totalTime;

    private String grade;

    private String term;

    private String major;

    private String institute;

    private Integer totalScore;

    private String type;

    private String tips;
}
