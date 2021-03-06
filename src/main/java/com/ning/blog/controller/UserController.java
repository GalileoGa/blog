package com.ning.blog.controller;

import com.ning.blog.domain.ReturnCode;
import com.ning.blog.domain.User;
import com.ning.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author Nicholas-Ning
     * @Description //TODO 待完善的功能：用户密码的脱敏
     * @Date 15:18 2018/10/19
     * @Param [user]
     **/
    @PostMapping("/regist")
    @ResponseBody
    public Map<String, Object> signUp(User user) {
        Map<String, Object> returnMap = getReturnMap();
        if (user == null) {
            setReturnCode(returnMap, ReturnCode.INFORMATIONERROR.getCode());
            return returnMap;
        }
        logger.info("用户注册：姓名{} 账号{} 密码{}", user.getUserName(), user.getLoginName(), user.getPassword());
        Map<String, Object> param = new HashMap<>();
        param.put("loginName", user.getLoginName());
        User user1 = userService.getUserByParam(param);
        //用户名被占用的情况
        if (user.getLoginName().equals(user1.getLoginName())) {
            setReturnCode(returnMap, ReturnCode.REPEATREGISTRATION.getCode());
            return returnMap;
        }
        setReturnCode(returnMap, userService.saveUser(user) == 1 ? ReturnCode.SUCCESS.getCode() : ReturnCode.ERROR.getCode());
        return returnMap;
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user) {
        String loginName = user.getLoginName();
        String password = user.getPassword();
        logger.info("登陆:用户名:{} 密码:{}", loginName, password);//eg-->登陆:用户名:{guotongning} 密码:{guotongning}
        Map<String, Object> returnMap = getReturnMap();
        User loginUser = userService.checkUser(user);
        //登陆失败
        if (loginUser == null) {
            setReturnCode(returnMap, ReturnCode.LOGINERROR.getCode());
            return returnMap;
        }
        //登陆成功
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60 * 1000);//设置session一小时过期
        session.setAttribute("loginUser", loginUser);
        return returnMap;
    }

    @GetMapping("/currentUser")
    @ResponseBody
    public User getCurrentUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("loginUser");
    }

}
