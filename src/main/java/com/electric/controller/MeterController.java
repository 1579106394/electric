package com.electric.controller;

import com.electric.domain.Meter;
import com.electric.domain.User;
import com.electric.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/meter/")
public class MeterController {

    @Autowired
    private MeterService meterService;

    /**
     * 根据用户id查询其下面的电表，返回json
     */
    @RequestMapping("lookMeter.action")
    @ResponseBody
    public Meter lookMeter(Integer userId) {
        Meter meter = meterService.getByUserId(userId);
        return meter;
    }

    /**
     * 查看我的电表
     */
    @RequestMapping("myMeter.action")
    public String myMeter(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Meter meter = meterService.getByUserId(user.getUserId());
        model.addAttribute("meter", meter);
        return "meter/meter-my";
    }

}
