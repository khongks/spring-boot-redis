package com.example.redisdemo.models;

import java.io.Serializable;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("students")
@Data
public class Student implements Serializable {
   
    public enum Gender { 
        MALE, FEMALE
    }
 
    private String id;
    private String name;
    private Gender gender;
    private int grade;
}