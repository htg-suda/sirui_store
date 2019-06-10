package com.htg.file;

import com.htg.file.config.FileConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private FileConfig fileConfig;

    @Test
    public void test01() {
        log.info(fileConfig.toString());
    }
}
