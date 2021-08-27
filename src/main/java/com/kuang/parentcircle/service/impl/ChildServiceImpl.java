package com.kuang.parentcircle.service.impl;

import com.kuang.parentcircle.entity.Child;
import com.kuang.parentcircle.mapper.ChildMapper;
import com.kuang.parentcircle.service.ChildService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 孩子表 服务实现类
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements ChildService {
    @Override
    //@Cacheable(value = "systemUserCache", key = "#uid", unless = "#result == null")
    public void findSystemUserByUid(String uid) {
       baseMapper.selectOne(null);
    }
}
