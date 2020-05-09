package com.hb.cp.web.test;

import com.hb.mybatis.base.DmlMapper;
import com.hb.mybatis.helper.QueryCondition;
import com.hb.mybatis.helper.QueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Value("${simple.mybatis.result.isHumpMapping}")
    private String isHumpMapping;

    @GetMapping("/testSimpleMybatis")
    public void testSimpleMybatis() {
        QueryCondition query = QueryCondition.build("coupons_config")
                .addCondition(QueryType.LIKE, "coupon_name", "优惠券")
                .orderBy("gmt_create desc");
        List<CouponConfigDO> list = dmlMapper.dynamicSelect(CouponConfigDO.class, query);
        for (CouponConfigDO couponConfigDO : list) {
            System.out.println(couponConfigDO);
        }
        System.out.println(list.size());
    }

}
