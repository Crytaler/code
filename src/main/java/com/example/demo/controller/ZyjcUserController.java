package com.example.demo.controller;


import com.example.demo.entity.ZyjcUser;
import com.example.demo.service.IZyjcUserService;
import com.example.demo.util.ExcelUtils;
import com.example.demo.util.ExportPdf;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/user")
public class ZyjcUserController {

    @Autowired
    private IZyjcUserService iZyjcUserService;

    @GetMapping("testPDF")
    @RequiresPermissions({"select"})
    public void test(@RequestHeader("token")String token,HttpServletRequest request, HttpServletResponse response) {
//        List<ZyjcUser> list = iZyjcUserService.list();
        try {
//            ExportPdf.ExportPdf(request,response,list);
            System.out.println("ceshi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @Title: impUser
     * @Description: excle导入
     * @param file
     * @return String
     */
    @PostMapping("/impUser")
    public String impUser( MultipartFile file){
        List<ZyjcUser> zyjcUsers = ExcelUtils.importData(file, 1, ZyjcUser.class);
        iZyjcUserService.saveBatch(zyjcUsers);
        return "success";
    }

    /**
     *
     * @Title: expUser
     * @Description: 导出excel
     * @param response
     * @return void
     */
    @GetMapping("/expUser")
    public void expUser(HttpServletResponse response){
        List<ZyjcUser> users = iZyjcUserService.list();
        if(users != null && users.size() > 0){
            ExcelUtils.exportExcel(users, null, "用户数据", ZyjcUser.class, "用户2020200623.xlsx", response);
        }
    }

}

