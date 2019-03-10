package com.electric.controller;

import com.electric.domain.Page;
import com.electric.domain.User;
import com.electric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("login.action")
    public String login(User user, Model model, HttpSession session) {
        // 根据用户名查询到用户
        User u = userService.getByUsername(user.getUsername());
        // 如果u为空，说明这个用户不存在，提示用户
        if (u == null) {
            model.addAttribute("error", "用户名或密码错误！");
            return "login";
        } else {
            // 存在，比对u的密码和user是否相同，如果不同，登录失败
            if (!u.getPassword().equals(user.getPassword())) {
                model.addAttribute("error", "用户名或密码错误！");
                return "login";
            }
        }
        // 登录成功，放到session
        session.setAttribute("user", u);
        // 重定向到首页
        return "redirect:/index.action";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout.action")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login.jsp";
    }

    /**
     * 分页查询用户
     */
    @RequestMapping("userList.action")
    public String userList(Page<User> p, Model model) {
        Page<User> userPage = userService.getByPage(p);
        model.addAttribute("page", userPage);
        return "user/user-list";
    }

    /**
     * 新增用户
     */
    @RequestMapping("addUser.action")
    public String addUser(User user, Model model) {
        // 根据用户名查询数据库是否已经存在
        User u = userService.getByUsername(user.getUsername());
        if (u != null) {
            model.addAttribute("error", "用户名已存在！");
            return "user/user-add";
        }
        // 用户不存在，进行添加
        userService.addUser(user);
        return "redirect:/user/userList.action";
    }

    /**
     * 根据id删除
     */
    @RequestMapping("deleteUser.action")
    public String deleteUser(Integer userId) {
        userService.deleteById(userId);
        return "redirect:/user/userList.action";
    }

    /**
     * 查看个人信息
     */
    @RequestMapping("myUser.action")
    public String myUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user/user-my";
    }

    /**
     * 修改个人信息
     */
    @RequestMapping("editMy.action")
    public String editMy(User user, Model model, HttpSession session) {
        userService.updateUser(user);
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 查询用户信息，跳转到修改页面
     */
    @RequestMapping("toEdit.action")
    public String toEdit(User user, Model model) {
        User u = userService.getById(user.getUserId());
        model.addAttribute("user", u);
        return "user/user-edit";
    }

    /**
     * 修改用户
     */
    @RequestMapping("editUser.action")
    public String editUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/userList.action";
    }

    @RequestMapping("arrears.action")
    @ResponseBody
    public User arrears(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getUserFlag() == 1) {
            return user;
        }
        return null;
    }

}
