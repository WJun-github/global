package com.wj.mongo.entitty;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/14 0014
 * @description
 */
@Data
@Document(collection = "user")
public class User {

    @MongoId
    private String id;
    @Field("name")
    private String name;
    @Field("age")
    private Integer age;
    @Field("nation")
    private String nation;
    @Field("address")
    private String address;
}
