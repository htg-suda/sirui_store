package com.htg.good;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htg.common.result.CommonResult;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.good.entity.UserBean;
import com.htg.good.exception.GlobalException;
import com.htg.good.service.IGoodSpuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private IGoodSpuService iGoodSpuService;

    @Test
    public void test01() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserBean userBean = new UserBean();
        userBean.setId(1);
        BigDecimal bigDecimal = new BigDecimal(0.01);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal("0.02"));

        userBean.setPrice(multiply);

        String str = mapper.writeValueAsString(userBean);

        log.info("========>{}", str);
        log.info("========>{}", bigDecimal1);
        log.info(new BigDecimal("0.02").toString());
    }

    @Test
    public void test02() throws GlobalException {
        CommonResult<ShopGoodSpuDetailVo> shopGoodSpuDetailById = iGoodSpuService.getShopGoodSpuDetailById(2);
        ShopGoodSpuDetailVo data = shopGoodSpuDetailById.getData();
    }


}
