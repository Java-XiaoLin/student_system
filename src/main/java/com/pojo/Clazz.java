package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

//班级实体对象
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Clazz {
    private String id;
    private String name;
    private String tagid;//标签外键

    private Tag tag;//当前班级的标签对象


}
