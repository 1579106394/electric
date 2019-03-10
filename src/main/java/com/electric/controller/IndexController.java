package com.electric.controller;

import com.electric.domain.Meter;
import com.electric.domain.Price;
import com.electric.domain.User;
import com.electric.service.MeterService;
import com.electric.service.PriceService;
import com.electric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PriceService priceService;
    @Autowired
    private UserService userService;
    @Autowired
    private MeterService meterService;

    /**
     * 查询欢迎界面需要的数据
     *
     * @return
     */
    @RequestMapping("/index.action")
    public String index(Model model, HttpSession session) {
        // 获取登录信息，根据角色来判断需要查询的数据
        User user = (User) session.getAttribute("user");

        // 查询当前电费，放到model中
        Price price = priceService.getByMonth(new SimpleDateFormat("yyyy-MM").format(new Date()));
        model.addAttribute("price", price);

        if (user.getUserFlag() == 2) {
            // 管理员查询数据
            // 查询前五名欠费用户，放到model中
            List<User> userList = userService.getArrearsList();
            model.addAttribute("userList", userList);
        }

        if (user.getUserFlag() == 1) {
            // 普通用户查询数据
            // 查询我的电表数据
            Meter meter = meterService.getByUserId(user.getUserId());
            model.addAttribute("meter", meter);
        }
        return "index";
    }

}
