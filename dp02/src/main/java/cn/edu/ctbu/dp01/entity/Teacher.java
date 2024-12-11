package cn.edu.ctbu.dp01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_teacher")
public class Teacher {
    //主键 自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //姓名
    private String name;
    //密码
    private String subject;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //学工号
    private String tno;
}
