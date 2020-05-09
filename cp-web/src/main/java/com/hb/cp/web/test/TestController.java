package com.hb.cp.web.test;

import com.hb.mybatis.base.DmlMapper;
import com.hb.mybatis.helper.QueryCondition;
import com.hb.mybatis.helper.QueryType;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/testSimpleMybatis")
    public void testSimpleMybatis() {
        QueryCondition query = QueryCondition.build("")
                .addCondition(QueryType.LIKE, "coupon_name", "优惠券");
        List<CouponConfigDO> list = dmlMapper.dynamicSelect(CouponConfigDO.class, query);
        System.out.println(list.size());
    }

}
