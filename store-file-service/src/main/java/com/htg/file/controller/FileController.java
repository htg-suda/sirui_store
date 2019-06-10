package com.htg.file.controller;

import com.htg.common.result.CommonResult;
import com.htg.file.config.FileConfig;
import com.htg.file.result.RespUrl;
import com.htg.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("file")
@Api(value = "FileController", tags = "文件服务")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileConfig fileConfig;

    /* domain 为 category, shop ...
     * type 为 image video 等等 ....
     *下载文件路径 为 http://localhost:8891/file/pub/{domain}/{type}/2019-11-11/xxxxxxx.png
     * */

    @ApiOperation(value = "上传分类图片", notes = "上传文件")
    @RequestMapping(value = "/upload/{domain}/{type}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<RespUrl> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String domain, @PathVariable String type) {
        //    String path = global_file_path + "/res/public/img/category/icon/";

        String globalPath = fileConfig.getGlobal_path();
        String publicRes = fileConfig.getPublic_res();
        String domainTypePath = "/" + domain + "/" + type + "/";

        //  Map<String, String> pubResMap = fileConfig.getPub_res_map();
        // String domainPath = pubResMap.get(domain);
        String path = globalPath + publicRes + domainTypePath;
        log.info("path is {}", path);
        return fileService.saveFile(file, path, domainTypePath);
    }
    /* 文件下载 */
}
