package com.kuang.parentcircle.service;

import com.kuang.parentcircle.entity.Child;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 孩子表 服务类
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
public interface ChildService extends IService<Child> {
    void findSystemUserByUid(String uid);

}
