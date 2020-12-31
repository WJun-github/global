package com.wj.mongo.resource;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import com.wj.mongo.entitty.JsonResult;
import com.wj.mongo.entitty.User;
import com.wj.mongo.util.BeanUtil;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

  @Autowired private MongoConverter converter;

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
    MongoClient client = MongoClients.create("mongodb://localhost:27017");
    MongoDatabase db = client.getDatabase("test");
    MongoCollection<Document> user = db.getCollection("user");
    BasicDBObject basic = new BasicDBObject();
    basic.put("_id", new ObjectId("5fd81f627642641d15d5ad7d"));
    FindIterable<Document> documents = user.find(basic);
    Document doc=new Document();
    doc.append("name","yhm").append("nation","回族").append("age",66).append("address","中国江苏南京");
    user.insertOne(doc);
    MongoCursor<Document> cursor = documents.cursor();
    while (cursor.hasNext()) {
      Document document = cursor.next();
      User read = converter.read(User.class, document);
      System.out.println(read.toString());
    }
    List<User> users =
        template.find(
            Query.query(Criteria.where("id").is("5fd81f627642641d15d5ad7d")), User.class, "user");
    return JsonResult.success(users);
  }

  @PostMapping("/update")
  public JsonResult update(@RequestBody User user) {
    try {
      Update update = new Update();
      Query query=new Query();
      query.addCriteria(Criteria.where("_id").is("5fd820e8ea5c955e019e889d"));
      setUpdate(update, user);
      template.upsert(
          query,
          update,
          User.class,
          "user");
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
