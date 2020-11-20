package com.wj.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private String birthDay;

    private String gender;

}
