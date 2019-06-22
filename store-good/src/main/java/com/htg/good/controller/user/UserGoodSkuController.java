package com.htg.good.controller.user;
import com.htg.common.dto.good.user.UserSkuQuery;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.good.user.UserGoodSkuDetailVo;
import com.htg.common.vo.good.user.UserGoodSkuVo;
import com.htg.common.vo.good.user.UserQuerySkuVo;
import com.htg.good.service.IGoodSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@Api(value = "UserGoodSkuController", tags = "用户002-商品sku模块")
@Validated
@RestController
@RequestMapping("/user/sku")
public class UserGoodSkuController {
    /* 获取 sku 列表 */

    /* 获取sku详情*/
    @Autowired
    private IGoodSkuService skuService;

    @ApiOperation(value = "列出商品sku")
    @ResponseBody
    @PostMapping("/search")
    public CommonResult<RespPage<UserQuerySkuVo>> listSku(@Valid @RequestBody UserSkuQuery userSkuQuery) {
        /* todo 这里的查询的sku 没有判断 SPU 是否已经审核通过 */
        return skuService.listByQuery(userSkuQuery);
    }


    /* 获取 用户端的SPU 详情 */
    @ApiOperation(value = "根据sku 编号 查找 SKU")
    @ResponseBody
    @PostMapping("/info/{skuNum}")
    public CommonResult<UserGoodSkuVo> getUserSkuByNum(@PathVariable("skuNum") String skuNum) throws GlobalException {
        /* todo 这里的查询的sku 没有判断 SPU 是否已经审核通过 */
        return skuService.getUserSkuByNum(skuNum);
    }

    @ApiOperation(value = "根据sku 编号 查找 SKU")
    @ResponseBody
    @PostMapping("/detail/{skuNum}")
    public CommonResult<UserGoodSkuDetailVo> getUserSkuDetailByNum(@PathVariable("skuNum") String skuNum) throws GlobalException {
        /* todo 这里的查询的sku 没有判断 SPU 是否已经审核通过 */
        return skuService.getUserSkuDetail(skuNum);
    }

}
