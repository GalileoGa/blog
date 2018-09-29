package com.ning.blog.controller;

import com.ning.blog.domain.ReturnCode;
import com.ning.blog.domain.Tips;
import com.ning.blog.service.TipsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 用途：
 * 作者：郭桐宁
 * 时间：2018/9/27 9:56
 * Version:1.0
 */
@Controller
@RequestMapping("/blog/Tips")
@ResponseBody
public class TipsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TipsController.class);

    @Autowired
    private TipsService tipsService;

    @RequestMapping("/addTips")

    public Map<String, Object> addTips(HttpServletRequest request, HttpServletResponse response, Tips tips) {
        logger.info("添加一个Tips");
        Map<String, Object> returnMap = getReturnMap();
        int result = tipsService.addTips(tips);
        if (result != 1) {
            setReturnCode(returnMap, ReturnCode.ERROR);
        }
        return returnMap;
    }

    @RequestMapping("/UserTips")
    public Map<String, Object> userTIps(HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询一波UserTips");
        Map<String, Object> returnMap = getReturnMap();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Tips> tipsById = tipsService.getTipsByUserId(id);
        setReturnObject(returnMap, "userTipsList", tipsById);
        return returnMap;
    }

}
