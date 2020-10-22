package com.tt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.pojo.*;
import com.tt.service.CourseService;
import com.tt.service.SpeakerService;
import com.tt.service.SubjectService;
import com.tt.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * (Video)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@Controller
@RequestMapping("video")
public class VideoController {
    /**
     * 服务对象
     */
    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;

/*    @Autowired
    private SubjectService subjectService;*/

    @RequestMapping("list")
    public String list(Model model,
                       QueryVo queryVo,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.selectAll();

        PageHelper.startPage(pageNum, 10);
        List<Video> videoList = videoService.findAll(queryVo);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);

        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);
        model.addAttribute("videoList", videoList);
        model.addAttribute("queryVo", queryVo);
        model.addAttribute("pageInfo", pageInfo);

        return "/behind/videoList.jsp";
    }

    @ResponseBody
    @RequestMapping("videoDel")
    public String videoDel(Integer id) {

        return videoService.deleteById(id) == 1 ? "success" : "false";
    }

    @RequestMapping("delBatchVideos")
    public void delBatchVideos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String checkedArr = request.getParameter("checkedArr");
        String[] ids = checkedArr.split(",");
        videoService.deleteVideos(ids);
        response.sendRedirect("/video/list");
    }


    @RequestMapping("addVideo")
    public String addVideo(Model model) {
        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.selectAll();

        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);

        return "/behind/addVideo.jsp";
    }

    @RequestMapping("edit")
    public String edit(Integer id, Model model) {
        Video video = videoService.queryById(id);
        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.selectAll();

        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);
        model.addAttribute("video", video);

        return "/behind/addVideo.jsp";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Video video, Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        if (null != id ) {
            videoService.update(video);
        } else {
            videoService.insert(video);
        }
        return "redirect:/video/list";
    }


/*    @RequestMapping("showVideo")
    public ModelAndView showVideo(@RequestParam(value = "videoId") Integer id, String subjectName){
        Video video = videoService.findVideo(id);
        Course course = courseService.fingByCoursePlus(video.getCourseId());

        ModelAndView modelAndView = new ModelAndView();
        List<Subject> subjectList = subjectService.findAllSubject();
        modelAndView.addObject("video",video);
        modelAndView.addObject("course",course);
        modelAndView.addObject("subjectName",subjectName);
        modelAndView.addObject("subjectList",subjectList);
        modelAndView.setViewName("/before/section.jsp");
        return modelAndView;*/
}