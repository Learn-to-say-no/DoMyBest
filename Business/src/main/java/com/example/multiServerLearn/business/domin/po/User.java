package com.example.multiServerLearn.business.domin.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("score")
    private Integer score;
}
