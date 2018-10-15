package com.ning.blog.controller;

import com.ning.blog.domain.ReturnCode;
import com.ning.blog.domain.Tips;
import com.ning.blog.domain.User;
import com.ning.blog.service.TipsService;
import com.ning.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addTips", method = RequestMethod.POST)
    public Map<String, Object> addTips(HttpServletRequest request, HttpServletResponse response, Tips tips) {
        logger.info("添加一个Tips");
        Map<String, Object> returnMap = getReturnMap();
        int result = tipsService.addTips(tips);
        if (result != 1) {
            setReturnCode(returnMap, ReturnCode.ERROR.getCode());
        }
        return returnMap;
    }

    @RequestMapping(value = "/UserTips", method = RequestMethod.POST)
    public Map<String, Object> userTIps(HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询一波UserTips");
        Map<String, Object> returnMap = getReturnMap();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Map<String, Object>> tipsList = new ArrayList<>();
        for (Tips tips : tipsService.getTipsByUserId(id)) {
            Map<String, Object> tipsMap = new HashMap<>();
            User user = userService.getUserById(tips.getUserId());
            tipsMap.put("tipsid", tips.getId());
            tipsMap.put("author", user.getUserName());
            tipsMap.put("title", tips.getTitle());
            tipsMap.put("content", tips.getContent());
            String blogimgs = tips.getBlogimgs();
            String[] imgs = blogimgs.split(",");
            if (imgs.length >= 3) {
                String[] img = new String[]{imgs[0], imgs[1], imgs[2]};
                tipsMap.put("imgs", img);//如果这条微博图片数量大于等于3则全部显示
            } else if (imgs.length < 3) {
                String[] img = new String[]{imgs[0]};
                tipsMap.put("imgs", img);//图片数量不够三张显示第一张
            }
            tipsMap.put("time", tips.getDateStrL(tips.getCreateTime()));
            tipsMap.put("weight", tips.getWeight());
            tipsMap.put("like", tips.getLikeNum());
            tipsMap.put("dislike", tips.getDislikeNum());
            tipsList.add(tipsMap);
        }
        setReturnObject(returnMap, "tipsList", tipsList);
        return returnMap;
    }

    @PostMapping("/like")
    public Map<String, Object> addLike(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> returnMap = getReturnMap();
        int tipsid = Integer.parseInt(request.getParameter("tipsid"));
        Tips tipsById = tipsService.getTipsById(tipsid);
        tipsById.setLikeNum(tipsById.getLikeNum() + 1);
        tipsById.setWeight(tipsById.getWeight() + 1);
        setReturnCode(returnMap, tipsService.updateTips(tipsById) == 1 ? ReturnCode.SUCCESS.getCode() : ReturnCode.ERROR.getCode());
        setReturnObject(returnMap, "like", tipsById.getLikeNum());
        return returnMap;
    }

    @PostMapping("/dislike")
    public Map<String, Object> addDislike(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> returnMap = getReturnMap();
        int tipsid = Integer.parseInt(request.getParameter("tipsid"));
        Tips tipsById = tipsService.getTipsById(tipsid);
        tipsById.setDislikeNum(tipsById.getDislikeNum() + 1);
        tipsById.setWeight(tipsById.getWeight() + 1);
        setReturnCode(returnMap, tipsService.updateTips(tipsById) == 1 ? ReturnCode.SUCCESS.getCode() : ReturnCode.ERROR.getCode());
        setReturnObject(returnMap, "dislike", tipsById.getDislikeNum());
        return returnMap;
    }

}
