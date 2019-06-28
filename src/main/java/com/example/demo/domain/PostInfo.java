package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "post_info")
@Getter
@Setter
@ToString
public class PostInfo {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String postNum;

    @Column
    private String sido;

    @Column
    @JsonIgnore
    private String sidoEng;

    @Column
    private String sigungu;

    @Column
    @JsonIgnore
    private String sigunguEng;

    @Column
    private String eupmyun;

    @Column
    @JsonIgnore
    private String eupmyunEng;

    @Column
    @JsonIgnore
    private String roadCode;

    @Column
    private String roadname;

    @Column
    @JsonIgnore
    private String roadnameEng;

    @Column
    @JsonIgnore
    private String isUnder;

    @Column
    @JsonIgnore
    private String buildingNum1;

    @Column
    @JsonIgnore
    private String buildingNum2;

    @Column
    @JsonIgnore
    private String buildingMnum;

    @Column
    @JsonIgnore
    private String delivery;

    @Column
    private String sigunguBnum;

    @Column
    @JsonIgnore
    private String legalCode;

    @Column
    private String dongname;

    @Column
    private String liname;

    @Column
    private String ldongname;

    @Column
    @JsonIgnore
    private String isMt;

    @Column
    private String jibun1;

    @Column
    @JsonIgnore
    private String serialNum1;

    @Column
    @JsonIgnore
    private String serialNum2;

    @Column
    @JsonIgnore
    private String oldPostnum;

    @Column
    @JsonIgnore
    private String serialPostnum;

}
