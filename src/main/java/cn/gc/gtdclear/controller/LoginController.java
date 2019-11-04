package cn.gc.gtdclear.controller;

import cn.gc.gtdclear.api.ApiResultBuilder;
import cn.gc.gtdclear.domain.User;
import cn.gc.gtdclear.repository.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 宫成 on 2019/1/24.
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/register")
    public Object register(HttpServletRequest request) {
        logger.info("==========register Start!==========");
        String userName = (String) request.getParameter("userName");
        User oldUser = userMapper.selectUser(userName);
        if (oldUser != null) {
            return ApiResultBuilder.getInstance().failed("这个名字被注册啦，选个其他的吧~");
        }

        User user = new User();
        //插入数据库
        user.setUser_name(userName);
        try {
            userMapper.saveUser(user);
            return ApiResultBuilder.getInstance().ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResultBuilder.getInstance().failed("注册失败" + e.getMessage());
        }
    }

    @RequestMapping("/login")
    public Object login(HttpServletRequest request) {
        logger.info("==========login Start!==========");
        String userName = (String) request.getParameter("userName");
        User user = userMapper.selectUser(userName);
        if (user == null) {
            return ApiResultBuilder.getInstance().failed("没有找到此用户，确认下名字填对了吗，如果是新用户要先注册的");
        } else {
            return ApiResultBuilder.getInstance().ok("登录成功",user);
        }
    }
}
