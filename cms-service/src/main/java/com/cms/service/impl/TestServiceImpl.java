package com.cms.service.impl;

import com.cms.dao.mapper.TestMapper;
import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service测试实现类
 * @Author: 可乐
 * @Date: 20:24 2020/11/20
 */
@Service
@SuppressWarnings("all")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 测试
     *
     * @return
     */
    @Override
    public int count() {
        return testMapper.count();
    }
}
