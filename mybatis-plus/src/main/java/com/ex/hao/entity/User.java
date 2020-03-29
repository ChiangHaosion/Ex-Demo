package com.ex.hao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/15
 * @Version V1.0
 **/
@Setter
@Getter
@ToString
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
    private Long managerId;
    private Date createTime;

}
