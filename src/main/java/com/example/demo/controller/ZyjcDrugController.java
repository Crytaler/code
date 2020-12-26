package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.annotation.Record;
import com.example.demo.entity.ZyjcDrug;
import com.example.demo.entity.ZyjcUser;
import com.example.demo.service.IZyjcDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/drug")
public class ZyjcDrugController {

    @Autowired
    private IZyjcDrugService iZyjcDrugService;

    @GetMapping("test")
    @Record(operate = "add",name = "添加")
    public String save() {
        ZyjcDrug zyjcDrug = new ZyjcDrug();
        zyjcDrug.setDrugName("测试ing0623");
//        boolean save = iZyjcDrugService.save(zyjcDrug);
        return "";
    }

    @GetMapping("page")
    public String page() {
//        QueryWrapper<ZyjcDrug> wrapper = new QueryWrapper<>();
//        Page<ZyjcDrug> page = new Page<>();
//        page.setCurrent(2);
//        page.setSize(20);
//        Page<ZyjcDrug> drugPage = iZyjcDrugService.page(page, wrapper);
        return "success";
    }

}

