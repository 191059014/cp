package com.hb.cp.web.controller;

import com.google.common.collect.Maps;
import com.hb.cp.web.model.PermissionDO;
import com.hb.mybatis.base.DmlMapper;
import com.hb.mybatis.helper.QueryCondition;
import com.hb.mybatis.helper.QueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 注释
 *
 * @author Mr.huang
 * @since 2020/5/7 13:59
 */
@RestController
@RequestMapping("/controller/wfp")
public class WfpController {

    @Autowired
    private DmlMapper dmlMapper;

    @GetMapping("/test")
    public void test() {
        HashMap<String, Object> condition = Maps.newHashMap();
        QueryCondition query = QueryCondition.build("t_permission")
                .addCondition(QueryType.LIKE, "permissionValue", "sys");
        List<PermissionDO> list = dmlMapper.dynamicSelect(PermissionDO.class, query);
        System.out.println(list);
    }

}
