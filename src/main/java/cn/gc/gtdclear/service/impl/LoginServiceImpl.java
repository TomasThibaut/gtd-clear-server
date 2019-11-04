package cn.gc.gtdclear.service.impl;

import cn.gc.gtdclear.service.LoginService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 宫成 on 2019/1/24.
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public Object userNameLogin(String userName) {
        Map<String, Object> map = new HashMap();
        map.put("userName", userName);

        return null;
    }
}
