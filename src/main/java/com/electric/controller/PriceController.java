package com.electric.controller;

import com.electric.domain.Page;
import com.electric.domain.Price;
import com.electric.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/price/")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * 发布电价
     * @param price
     * @return
     */
    @RequestMapping("addPrice.action")
    public String addPrice(Price price) {
        priceService.addPrice(price);
        return "redirect:/price/priceList.action";
    }

    /**
     * 分页查询
     */
    @RequestMapping("priceList.action")
    public String priceList(Page<Price> p, Model model) {
        Page<Price> page = priceService.getByPage(p);
        model.addAttribute("page", page);
        return "price/price-list";
    }

}
