package com.hb.cp.web.test;

import com.hb.mybatis.base.DmlMapper;
import com.hb.mybatis.helper.QueryCondition;
import com.hb.mybatis.helper.QueryType;
import com.hb.mybatis.helper.WhereCondition;
import com.hb.mybatis.model.PagesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .orderBy("gmtCreate desc")
                .limit(0,3);
        PagesResult<CouponConfigDO> pagesResult = dmlMapper.selectPages(CouponConfigDO.class, query);
        System.out.println(pagesResult);
    }

    @GetMapping("/testInsert")
    public void testInsert() {
        CouponConfigDO t = new CouponConfigDO();
        String timestamp = String.valueOf(System.currentTimeMillis());
        t.setBoxId(timestamp);
        t.setCouponName("优惠券测试" + timestamp);
        t.setCouponLedUrl("http://www.baidu.com");
        int updateRows = dmlMapper.insertBySelective(t);
        System.out.println("影响行数：" + updateRows);
    }

    @GetMapping("/testUpdate")
    public void testUpdate() {
        CouponConfigDO t = new CouponConfigDO();
        String timestamp = String.valueOf(System.currentTimeMillis());
        t.setBoxId(timestamp);
        t.setCouponName("优惠券测试" + timestamp);
        t.setCouponImgUrl("imageurl");
        WhereCondition whereCondition = WhereCondition.build()
                .addCondition(QueryType.EQUALS, "id", 12);
        int updateRows = dmlMapper.updateBySelective(t, whereCondition);
        System.out.println("影响行数：" + updateRows);
    }

    @GetMapping("/testDelete")
    public void testDelete() {
        WhereCondition whereCondition = WhereCondition.build()
                .addCondition(QueryType.EQUALS, "id", 12);
        int updateRows = dmlMapper.deleteBySelective(CouponConfigDO.class, whereCondition);
        System.out.println("影响行数：" + updateRows);
    }

}
