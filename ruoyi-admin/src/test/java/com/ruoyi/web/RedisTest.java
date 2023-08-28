package com.ruoyi.web;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.redis.RedisUtil;
import com.ruoyi.test.domain.FirstCom;
import com.ruoyi.test.service.IFirstComService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : weizx
 * @date : 2023/8/22
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private IFirstComService firstComService;

    @Test
    public void testA() {
        String[] strArray = {"1","2","3","4","5","6"};
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","name");
        map.put("tel","10010");
        map.put("type",1);
        map.put("time","2020-12-21 00:00:00");
        map.put("country","中国");
        map.put("province","浙江");
        map.put("list", Arrays.asList(strArray));
        redisUtil.setKey("test", JSON.toJSONString(map));
    }

    @Test
    public void testB() {
        String test = "";
        if (redisUtil.existKey("test")) {
            test = redisUtil.getString("test");
        }
        System.out.println(test);
    }

    @Test
    public void testC() {
        FirstCom firstCom = firstComService.selectFirstComById("1");
        int i = firstComService.deleteFirstComByIds("1,3");
        System.out.println(
                JSON.toJSONString(i)
        );
    }
}
