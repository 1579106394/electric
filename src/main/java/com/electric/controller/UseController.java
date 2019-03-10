package com.electric.controller;

import com.electric.domain.Page;
import com.electric.domain.Use;
import com.electric.domain.User;
import com.electric.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/use/")
public class UseController {

    @Autowired
    private UseService useService;

    /**
     * 查询用电记录
     * @param p
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("useList.action")
    public String useList(Page<Use> p, Model model, HttpServletRequest request) {
        // 如果当前登录用户不是管理员，就只查询自己的
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUserFlag() == 1) {
            p.getParams().put("user", user);
        }
        Page<Use> page = useService.getByPage(p);
        model.addAttribute("page", page);
        return "use/use-list";
    }


    /**
     * 根据id删除用电记录
     */
    @RequestMapping("deleteById.action")
    public String deleteById(Integer useId) {
        useService.deleteById(useId);
        return "redirect:/use/useList.action";
    }


    /**
     * 查询某个用户六个月用电记录
     * @return
     */
    @RequestMapping("lookUse.action")
    @ResponseBody
    public List<Use> lookUse(Integer userId) {
        List<Use> useList = useService.getByUserId(userId);
        return useList;
    }


}
