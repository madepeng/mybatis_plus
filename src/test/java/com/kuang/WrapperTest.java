package com.kuang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kuang.entity.User;
import com.kuang.mapper.UserMapper;
import com.kuang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    void test1() {
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper();
//        queryWrapper.eq(User::getName,"fsdf");
        userMapper.selectList(queryWrapper).forEach(System.out::println); // 和我们刚才学习的map对比一下
    }

    @Test
    void test2() {
        // 查询名字狂神说
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "狂神说");
        User user = userMapper.selectOne(wrapper); // 查询一个数据，出现多个结果使用List 或者 Map
        System.out.println(user);
    }

    @Test
    void test3() {
        // 查询年龄在 20 ~ 30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30); // 区间
        Integer count = userMapper.selectCount(wrapper);// 查询结果数
        System.out.println(count);
    }

    // 模糊查询
    @Test
    void test4() {
        // 查询年龄在 20 ~ 30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 左和右  t%
        wrapper
                .notLike("name", "e")
                .likeRight("email", "t");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 模糊查询
    @Test
    void test5() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id<3");

        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    //测试六
    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过id进行排序
        wrapper.orderByAsc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    //测试7
    @Test
    void test7() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, 6);

        User user = new User();
//        user.setId(1L);
        user.setAge(11111);
        user.setName("fdsfjoahfeogaeg");
//        System.out.println("res:" + userMapper.updateById(user));

        System.out.println(userMapper.update(user, queryWrapper));
    }


    @Test
    void test9() {
        LambdaUpdateWrapper<User> change = Wrappers.lambdaUpdate(User.class).set(User::getName, "change").in(User::getId, 1, 2, 3, 4, 5, 6);
        userMapper.update(null, change);
    }


    @Test
    void test10() {
        LambdaQueryWrapper<User> select = Wrappers.lambdaQuery(User.class).in(User::getId, 1, 2, 3).select(User::getName);
        System.out.println(userMapper.selectList(select));
    }


    @Test
    void test11() {
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getId, 100019));
        user.setName("ooooooo");
        //user.setId(2L);
        userMapper.updateById(user);
        //userMapper.update(user, null);
        //userMapper.update(user, Wrappers.lambdaUpdate(User.class).eq(User::getId, 100018));
       /* userMapper.update(null, Wrappers.lambdaUpdate(User.class)
                .set(User::getName, "fdsfsdfdsfsd").eq(User::getId, 100017));
*/
    }

    @Test
    void testbatch() {
        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            userList.add(new User(Long.valueOf(i), i + "", i, i + "", LocalDateTime.now(), LocalDateTime.now()));
        }
        userService.saveBatch(userList);
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }

    @Test
    void testbatch1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            userService.save(new User(Long.valueOf(i), i + "", i, i + "", LocalDateTime.now(), LocalDateTime.now()));
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
}
