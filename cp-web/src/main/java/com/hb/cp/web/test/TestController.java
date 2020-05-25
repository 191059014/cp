package com.hb.cp.web.test;

import com.hb.mybatis.base.DmlMapper;
import com.hb.mybatis.helper.QueryCondition;
import com.hb.mybatis.helper.QueryType;
import com.hb.unic.util.build.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用来测试的controller
 *
 * @author Mr.huang
 * @since 2020/5/7 13:59
 */
@RestController
@RequestMapping("/controller/test")
public class TestController {

    @Autowired
    private DmlMapper dmlMapper;

    @Value("${username}")
    private String username;

    @GetMapping("/testQuery")
    public void testQuery() {
        QueryCondition query = QueryCondition.build()
                .addCondition(QueryType.LIKE, "couponName", "优惠券")
                .orderBy("gmtCreate desc");
        List<CouponConfigDO> list = dmlMapper.dynamicSelect(CouponConfigDO.class, query);
        for (CouponConfigDO couponConfigDO : list) {
            System.out.println(couponConfigDO);
        }
        System.out.println(list.size());
    }

    @GetMapping("/testInsert")
    public void testInsert() {
        CouponConfigDO t = new CouponConfigDO();
        String timestamp = String.valueOf(System.currentTimeMillis());
        t.setBoxId(timestamp);
        t.setCouponName("优惠券测试" + timestamp);
        int updateRows = dmlMapper.insertBySelective(t);
        System.out.println("影响行数：" + updateRows);
    }

    @GetMapping("/testUpdate")
    public void testUpdate() {
        CouponConfigDO t = new CouponConfigDO();
        String timestamp = String.valueOf(System.currentTimeMillis());
        t.setBoxId(timestamp);
        t.setCouponName("优惠券测试" + timestamp);
        Map<String, Object> map = MapBuilder.build().add("id", 12).get();
        int updateRows = dmlMapper.updateBySelective(t, map);
        System.out.println("影响行数：" + updateRows);
    }

    @GetMapping("/testDelete")
    public void testDelete() {
        CouponConfigDO t = new CouponConfigDO();
        t.setId(12);
        dmlMapper.deleteBySelective(t);
    }

}
