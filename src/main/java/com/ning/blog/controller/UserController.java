package com.ning.blog.controller;

import com.ning.blog.domain.ReturnCode;
import com.ning.blog.domain.User;
import com.ning.blog.service.UserService;
import com.ning.blog.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

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
        param.put("password", user.getPassword());
        User user1 = userService.getUserByParam(param);
        if (user.equals(user1)) {
            setReturnCode(returnMap, ReturnCode.REPEATREGISTRATION.getCode());
        }
        user.setSalt(StringUtil.getSalt());//生成用户密码加密盐值
        user.setWeight(0);//用户初始权重0
        setReturnCode(returnMap, userService.saveUser(user) == 1 ? ReturnCode.SUCCESS.getCode() : ReturnCode.ERROR.getCode());
        return returnMap;
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user) {
        String loginName = user.getLoginName();
        String password = user.getPassword();
        logger.info("登陆:用户名:{} 密码:{}", loginName, password);
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

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        return userService.saveUser(user) == 1 ? "成功！" : "失败";
    }
}
