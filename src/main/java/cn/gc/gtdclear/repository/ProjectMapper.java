package cn.gc.gtdclear.repository;

import cn.gc.gtdclear.domain.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 宫成 on 2019/1/24.
 */
public interface ProjectMapper {

    @Insert(
            "INSERT INTO project(user_id,content,create_time,start_time,finish_time,finish_flag) "
                    + "VALUES(#{user_id},#{content},#{create_time},#{start_time},#{finish_time},#{finish_flag})"
    )
    void saveProject(Project project);

    @Select("select * from project where finish_flag = 0 and user_id = #{user_id}")
    List<Project> getUnFinishedProject(String userId);

    @Select("select * from project where finish_flag = 1 and user_id = #{user_id}")
    List<Project> getFinishedProject(String userId);

    @Update("update project set user_id = #{user_id},content = #{content},create_time = #{create_time} ,start_time = #{start_time},finish_time = #{finish_time},finish_flag = #{finish_flag} where id = #{id}")
    void updateProject(Project project);
}
