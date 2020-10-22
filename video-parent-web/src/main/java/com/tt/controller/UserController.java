package com.tt.controller;

import com.tt.pojo.User;
import com.tt.service.UserService;
import com.tt.videos.utils.ImageCut;
import com.tt.videos.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:13:19
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpServletRequest request) {
        user = userService.selectUserByEmailAndPassword(user);
        if (null != user) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user.getEmail());
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "success";
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(String email) {
        User user = userService.selectUserByEmail(email);
        if (null == user) {
            return "success";
        }
        return "hasUser";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user, HttpServletRequest request) {
        user.setCreatetime(new Date());
        if (userService.insertUser(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user.getEmail());
            return "success";
        }
        throw new RuntimeException("用户注册失败");
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "/before/forget_password.jsp";
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email, HttpServletRequest request) {
        //验证用户是否存在
        if ("success".equals(validateEmail(email))) {
            return "hasNoUser";
        }

        String code = MailUtils.getValidateCode(6);
        boolean flag = MailUtils.sendMail(email, "测试邮件随机生成的验证码是：" + code, "你好，这是一封测试邮件，无需回复。");
        if (flag) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("code", code);
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionEmail = (String) session.getAttribute("email");
        String sessionCode = (String) session.getAttribute("code");
        if (sessionEmail.equals(email) && sessionCode.equals(code)) {
            return "/before/reset_password.jsp";
        }
        return "redirect:/user/forgetPassword";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("code");
        User user = userService.selectUserByEmail(email);
        if (null != user) {
            user.setPassword(password);
            userService.updateUser(user);
            session.setAttribute("userAccount", user.getEmail());
        }
        return "redirect:/";
    }

    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.selectUserByEmail((String) session.getAttribute("userAccount"));
        session.setAttribute("user", user);
        return "/before/my_profile.jsp";
    }

    @RequestMapping("/loginOut2")
    public String loginOut2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "redirect:/";
    }

    @RequestMapping("/changeProfile")
    public String changeProfile() {
        return "/before/change_profile.jsp";
    }

    @RequestMapping("/updateUser")
    public String updateUser(String nickName, String sex, String birthday, String address, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setNickname(nickName);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAddress(address);
        userService.updateUser(user);
        return "redirect:/user/showMyProfile";
    }

    @RequestMapping("/passwordSafe")
    public String passwordSafe() {
        return "/before/password_safe.jsp";
    }

    @RequestMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (password.equals(user.getPassword())) {
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(newPassword);
        userService.updateUser(user);
        return "redirect:/user/showMyProfile";
    }

    @RequestMapping("/changeAvatar")
    public String changeAvatar() {
        return "/before/change_avatar.jsp";
    }

    @RequestMapping("/upLoadImage")
    public String upLoadImage(@RequestParam("image_file") MultipartFile imageFile, String x1, String x2, String y1, String y2, HttpServletRequest request) throws IOException {
        String path = "D:\\server\\apache-tomcat-8.5.31\\webapps\\video\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String filename = imageFile.getOriginalFilename();
        filename = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        imageFile.transferTo(new File(path, filename));

        int x1Int = (int) Double.parseDouble(x1);
        int x2Int = (int) Double.parseDouble(x2);
        int y1Int = (int) Double.parseDouble(y1);
        int y2Int = (int) Double.parseDouble(y2);
        new ImageCut().cutImage(path + "/" + filename, x1Int, y1Int, x2Int - x1Int, y2Int - y1Int);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setImgurl(filename);
        userService.updateUser(user);

        return "redirect:/user/showMyProfile";
    }

}