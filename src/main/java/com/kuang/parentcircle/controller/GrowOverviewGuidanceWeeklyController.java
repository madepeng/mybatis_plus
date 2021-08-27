package com.kuang.parentcircle.controller;


import com.kuang.parentcircle.entity.GrowOverviewGuidanceWeekly;
import com.kuang.parentcircle.service.GrowOverviewGuidanceWeeklyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 总览_学习指导表 前端控制器
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
@RestController
@RequestMapping("/parentcircle/grow-overview-guidance-weekly")
public class GrowOverviewGuidanceWeeklyController {
    @Resource
    private GrowOverviewGuidanceWeeklyService growOverviewGuidanceWeeklyService;

    @ApiOperation(value = "获取所有记录")
    @GetMapping(value = "/find")
    public List<GrowOverviewGuidanceWeekly> findSystemUser() {
        List<GrowOverviewGuidanceWeekly> list = growOverviewGuidanceWeeklyService.list();
        return list;
    }
}

