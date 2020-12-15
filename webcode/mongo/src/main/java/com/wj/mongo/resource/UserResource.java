package com.wj.mongo.resource;

import com.mongodb.DBObject;
import com.wj.mongo.util.BeanUtil;
import com.wj.mongo.entitty.JsonResult;
import com.wj.mongo.entitty.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/14 0014
 * @description
 */
@RequestMapping("/user")
@RestController
public class UserResource {

  @Autowired private MongoTemplate template;

  @GetMapping("/getList")
  public JsonResult getList() {
    List<User> data = template.findAll(User.class, "user");
    return JsonResult.success(data);
  }

  @PostMapping("/save")
  public JsonResult save(@RequestBody User user) {
    try {
      DBObject mongoEntity = BeanUtil.bean2DBObject(user);
      template.insert(user, "user");

      return JsonResult.success();
    } catch (Exception e) {
      e.printStackTrace();
      return JsonResult.failure();
    }
  }

  @GetMapping("/getByCondition")
  public JsonResult getByCondition() {
    List<User> users =
        template.find(Query.query(Criteria.where("name").is("fiberhome3")), User.class, "user");
    return JsonResult.success(users);
  }

  @PostMapping("/update")
  public JsonResult update(@RequestBody User user) {
    try {
      Update update = new Update();
      setUpdate(update, user);
      template.upsert(
          Query.query(Criteria.where("name").is(null)), update, User.class, "user");
      return JsonResult.success();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return JsonResult.failure(-1, e.getMessage());
    }
  }

  public static <T> void setUpdate(Update update, T t) throws IllegalAccessException {
    Class<?> clazz = t.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (!field.isAccessible()) {
        field.setAccessible(true);
      }
      String name = field.getName();
      Object value = field.get(t);
      if (null == value) {
        continue;
      } else {
        update.set(name, value);
      }
    }
  }
}
