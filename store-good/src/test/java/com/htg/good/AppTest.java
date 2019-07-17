package com.htg.good;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htg.common.result.CommonResult;
import com.htg.common.vo.good.shop.ShopGoodSpuDetailVo;
import com.htg.common.vo.good.user.UserQuerySkuVo;
import com.htg.good.entity.UserBean;
import com.htg.common.exception.GlobalException;
import com.htg.good.mapper.GoodSkuMapper;
import com.htg.good.service.IGoodSpuService;
import com.htg.good.simple.QueryBody;
import com.htg.common.dto.good.user.SpecItem;
import com.htg.common.dto.good.user.UserSkuQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private IGoodSpuService iGoodSpuService;

    @Autowired
    private GoodSkuMapper mapper;

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


    @Test
    public void test03() {
        List<QueryBody> bodies = new ArrayList<>();
        bodies.add(new QueryBody("产品类型", ""));
        // bodies.add(new QueryBody("经度", ""));
        //  bodies.add(new QueryBody("纬度", ""));
        // bodies.add(new QueryBody("具体位置", ""));

        //log.info("spu list is {}", mapper.selectSpuByList(bodies));

        List<QueryBody> bodies2 = new ArrayList<>();
        bodies2.add(new QueryBody("产品类型", "工位,会议室"));
        // log.info("spu list is {}", mapper.selectSpuBySpecList(bodies2));
    }

    @Test
    public void test05() {
        UserSkuQuery skuQuery = new UserSkuQuery();
        // skuQuery.setKeyWord("java");
        List<SpecItem> list = new ArrayList<>();
        list.add(new SpecItem("产品类型", "会议室", "="));
        log.info("sku -- start");
        skuQuery.setSpecItems(list);
        //  List<UserQuerySkuVo> userQuerySkuVos = mapper.selectSkuBySpecList(skuQuery);
        //    log.info("sku list is {}", userQuerySkuVos);
    }

    @Test
    public void test() {
        log.info("====>email  {}"+inferNameAsEmail("1250068829@qq.com"));
        log.info("====>tel {}"+inferNameAsTel("18717919376"));
    }


    private boolean inferNameAsEmail(String name) {

        String patternStr = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patternStr);
        return pattern.matcher(name).matches();
    }

    private boolean inferNameAsTel(String name) {
        String patternStr = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$";
        Pattern pattern = Pattern.compile(patternStr);
        return pattern.matcher(name).matches();
    }
}
*/
