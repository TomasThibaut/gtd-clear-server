package cn.gc.gtdclear.repository;

import cn.gc.gtdclear.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 宫成 on 2019/1/24.
 */

public interface UserMapper {
    @Insert("INSERT INTO user(user_name) VALUES(#{userName})")
    void saveUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User selectUser(@Param("userName") String userName);


}
