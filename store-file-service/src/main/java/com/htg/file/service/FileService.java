package com.htg.file.service;


import com.htg.common.result.CommonResult;
import com.htg.file.result.RespUrl;
import com.htg.file.utils.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
public class FileService {
    public CommonResult<RespUrl> saveFile(MultipartFile file, String path) {
        if (file.isEmpty()) {
            return CommonResult.error("上传失败");
        }

        /* 生成新文件的名字*/
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
        String newFileName = SnowFlakeUtil.getFlowIdInstance().nextId() + "." + suffix;


        /* 按照日期生成目录 */
        String dayTime = new DateTime(new Date()).toString("yyyy-MM-dd");
        File dir = new File(path + dayTime + "/");
        if (!dir.exists()) {
            dir.mkdirs();
        }


        /* 目标文件 */
        File dest = new File(dir, newFileName);
        try {
            file.transferTo(dest);
            log.info("-- 上传成功 --");
            return CommonResult.success(new RespUrl(dayTime + "/" + newFileName));
        } catch (IOException e) {
            log.error(e.toString(), e);
            return CommonResult.error("上传失败");
        }
    }
}
