package com.electric.controller;

import com.electric.domain.Money;
import com.electric.domain.Page;
import com.electric.domain.User;
import com.electric.service.MoneyService;
import com.electric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/money/")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;
    @Autowired
    private UserService userService;

    /**
     * 充电费
     */
    @RequestMapping("recharge.action")
    public String recharge(Money money, HttpSession session) {
        User user = (User) session.getAttribute("user");
        money.setUser(user);
        moneyService.addMoney(money);
        return "redirect:/money/moneyList.action";
    }

    /**
     * 管理员充电费
     */
    @RequestMapping("addMoney.action")
    public String addMoney(Money money) {
        User user = userService.getById(money.getUser().getUserId());
        money.setUser(user);
        moneyService.addMoney(money);
        return "redirect:/user/userList.action";
    }

    /**
     * 查看缴费记录
     */
    @RequestMapping("moneyList.action")
    public String moneyList(Page<Money> p, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getUserFlag()==1) {
            // 等于1，是普通用户，就只查这个用户的缴费信息
            p.getParams().put("user", user.getUserId());
        }
        Page<Money> page = moneyService.getByPage(p);
        model.addAttribute("page", page);
        return "money/money-list";
    }

    /**
     * 删除缴费信息
     */
    @RequestMapping("deleteMoney.action")
    public String deleteMoney(Integer moneyId) {
        moneyService.deleteById(moneyId);
        return "redirect:/money/moneyList.action";
    }

}
