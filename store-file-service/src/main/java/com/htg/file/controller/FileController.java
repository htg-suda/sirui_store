package com.htg.file.controller;

import com.htg.common.result.CommonResult;
import com.htg.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("file")
@Api(value = "FileController", tags = "文件服务")
public class FileController {
    @Autowired
    private FileService fileService;

    private String global_file_path = "/home/htg/work/temp/sirui_store_file";
    private String public_res = "/res/public";
    private String private_res = "/res/private";
    private String type_image = "/img";

    private String domain_user = "/user";
    private String domain_shop = "/shop";
    private String domain_admin = "/admin";
    private String domain_good = "/good";
    private String domain_category = "/category";


    /*
     * 用户头像所在的目录:
     * /res/private/img/user/portrait
     *
     * 类别图片
     * /res/public/img/category/icon
     *
     *
     * */
    @ApiOperation(value = "上传分类图片", notes = "上传文件")
    @RequestMapping(value = "/upload_category_icon_img", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadFile(@RequestParam("file") MultipartFile file) {
        String path = global_file_path + "/res/public/img/category/icon/";
        return fileService.saveFile(file, path);
    }
    /* 文件下载 */


}
