package cn.gc.gtdclear.controller;

import cn.gc.gtdclear.api.ApiResultBuilder;
import cn.gc.gtdclear.domain.Project;
import cn.gc.gtdclear.repository.ProjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 宫成 on 2019/1/25.
 */
@RestController
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ProjectMapper projectMapper;

    @RequestMapping("/getUnfinishedProjects")
    public Object getUnfinishedProjects(HttpServletRequest request) {
        logger.info("==========getUnfinishedProjects Start!==========");
        String userId = (String) request.getParameter("user_id");

        List<Project> unFinishedProject = projectMapper.getUnFinishedProject(userId);

        if (unFinishedProject == null || unFinishedProject.size() == 0) {
            return ApiResultBuilder.getInstance().ok("没有事项");
        } else {
            return ApiResultBuilder.getInstance().ok(unFinishedProject);
        }
    }

    @RequestMapping("/getFinishedProjects")
    public Object getFinishedProjects(HttpServletRequest request) {
        logger.info("==========getFinishedProjects Start!==========");
        String userId = (String) request.getParameter("user_id");

        List<Project> finishedProject = projectMapper.getFinishedProject(userId);

        if (finishedProject == null || finishedProject.size() == 0) {
            return ApiResultBuilder.getInstance().ok("没有事项");
        } else {
            return ApiResultBuilder.getInstance().ok(finishedProject);
        }
    }

    @RequestMapping("/updateProject")
    public Object updateProject(HttpServletRequest request) {
        logger.info("==========updateProject Start!==========");
        try {
            String json = request.getParameter("project");
            Project project = new Gson().fromJson(json, Project.class);
            projectMapper.updateProject(project);
            return ApiResultBuilder.getInstance().ok("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResultBuilder.getInstance().failed(e.getMessage());
        }
    }

    @RequestMapping("/saveProject")
    public Object saveProject(HttpServletRequest request) {
        logger.info("==========updateProject Start!==========");
        String json = request.getParameter("project");
        Project project = new Gson().fromJson(json, Project.class);
        try {
            projectMapper.saveProject(project);
            return ApiResultBuilder.getInstance().ok("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResultBuilder.getInstance().failed(e.getMessage());
        }
    }
}
