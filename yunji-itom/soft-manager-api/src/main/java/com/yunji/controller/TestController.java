package com.yunji.controller;

import com.google.protobuf.ServiceException;
import com.yunji.common.common.PageVo;
import com.yunji.common.common.ResponseInfo;
import com.yunji.common.exception.CommonErrorEnum;
import com.yunji.common.exception.SoftManagerErrorEnum;
import com.yunji.common.exception.YunjiException;
import com.yunji.dto.QueryDemoByPage;
import com.yunji.pojo.Demo;
import com.yunji.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 测试类
 * @author: du
 * @Date: 2020/9/7 8:47
 * @Modified:
 **/
@RestController
@Api(tags = "测试相关接口")
@RequestMapping(value = "/test", produces = {"application/json; charset=UTF-8"})
public class TestController {


    @Autowired
    DemoService demoService;


    @PostMapping("/setValue")
    @ApiOperation("测试接口1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "代码", defaultValue = "00001"),
            @ApiImplicitParam(name = "desc", value = "描述", defaultValue = "SUCCESS", required = true)
    })
    public ResponseInfo setValue(String code, @RequestParam(required = true) String desc) {
        ResponseInfo response = new ResponseInfo(code, desc);
        return response;
    }


    @GetMapping("/test")
    @ApiOperation("测试捕获异常")
    public ResponseInfo test() {
        try {
            return new ResponseInfo(CommonErrorEnum.SUCCESS);
        } catch (Exception e) {
            throw new YunjiException(CommonErrorEnum.SYSTEM_ERROR);
        }

    }

    @GetMapping("/abc")
    @ApiOperation("测试运行时异常")
    public void abc() {
        String a[] = {"1", "2"};
        System.out.printf(a[10]);

    }


    @ApiOperation(value = "采取mybatis方式查询")
    @ApiImplicitParam(name = "id", value = "记录id", paramType = "path", required = true)
    @GetMapping("/getUser/{id}")
    public ResponseInfo<Demo> getUser(@PathVariable("id") int id) {
        Demo demo = demoService.getDemoById(id);
        return new ResponseInfo(demo);
    }

    @ApiOperation(value = "采取mybatis-plus方式查询")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true)
    @GetMapping("/getUserInfo/{id}")
    public ResponseInfo<Demo> getUserInfo(@PathVariable("id") int id) {
        Demo demo = demoService.getById(id);
        return new ResponseInfo(demo);
    }

    @ApiOperation(value = "采取mybatis xml方式查询")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true)
    @GetMapping("/getUserByUserId")
    public ResponseInfo<Demo> getDemoByUserId(String userId) {
        Demo demo = demoService.getDemoByUserId(userId);
        return new ResponseInfo(demo);
    }

    @ApiOperation(value = "分页")
    @GetMapping("/getDemoByPage")
    public ResponseInfo<PageVo> getDemoByPage(QueryDemoByPage query) {

        long id = 1254l;

        return demoService.getDemoByPage(query);
    }


    @ApiOperation(value = "插入数据")
    @PostMapping("/insert/demo")
    public ResponseInfo insertDemo(@RequestBody Demo demo) {
        Boolean tag = demoService.save(demo);
        return new ResponseInfo(tag);
    }

}
