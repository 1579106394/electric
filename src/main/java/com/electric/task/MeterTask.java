package com.electric.task;

import com.electric.domain.Meter;
import com.electric.domain.Price;
import com.electric.domain.Use;
import com.electric.domain.User;
import com.electric.service.MeterService;
import com.electric.service.PriceService;
import com.electric.service.UseService;
import com.electric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时任务，主要是对电表的操作
 */
@Component
public class MeterTask {

    @Autowired
    private UseService useService;
    @Autowired
    private UserService userService;
    @Autowired
    private MeterService meterService;
    @Autowired
    private PriceService priceService;

    // @Scheduled(initialDelay = 1000, fixedDelay = 10000)

    /**
     * tomcat启动后每半小时执行一次
     * 默认每分钟使用一度电
     * 觉得慢可以把上面的注解打开，下面的注释掉，上面的是每10秒执行一次
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 60 * 30)
    public void moneyTask() {
        System.out.println("电费定时任务执行了");
        // 每次执行，查询这个月电价，然后从用户余额中扣除电价，电表数据更新
        String month = new SimpleDateFormat("yyyy-MM").format(new Date());
        Price price = priceService.getByMonth(month);
        // 得到电价
        Double money = price.getPriceMoney();
        // 查询所有电表（因为电表跟用户进行了关联，所以也相当于查到了所有用户）
        // 这样不用查询多次，提高了效率
        List<Meter> meterList = meterService.getAll();
        for (Meter meter : meterList) {
            // 用户电费余额减少
            User user = meter.getUser();
            user.setUserMoney(user.getUserMoney() - money);
            userService.updateUser(user);

            // 电表使用情况：止码+1，用电量+1，电费+money
            meter.setMeterCurrentNum(meter.getMeterCurrentNum() + 1);
            meter.setMeterNum(meter.getMeterNum() + 1);
            meter.setMeterMoney(meter.getMeterMoney() + money);
            meterService.UpdateMeter(meter);
        }
    }

    // @Scheduled(cron = "0 55 23 L * ?")
    /**
     * 电费使用记录定时任务，测试时为了看清楚效果，一小时执行一次
     * 实际使用需要每月执行一次，只需要打开上面的注解，把下面的注解注释掉
     * 上面的是每个月最后一天23点55分0秒执行一次（从右到左分别为年月日时分秒）
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 60 * 60)
    public void useTask() {
        System.out.println("使用记录定时任务执行了");
        // 获取当前月
        String month = new SimpleDateFormat("yyyy-MM").format(new Date());
        // 查询所有电表
        List<Meter> meterList = meterService.getAll();
        // 获取电表用户id、当前电费、使用电费、将这些数据和月份设置到使用情况里
        for (Meter meter : meterList) {
            Use use = new Use();
            use.setUser(meter.getUser());
            use.setUseMoney(meter.getMeterMoney());
            use.setUseNumber(meter.getMeterNum());
            use.setUseTime(month);
            // 添加用电记录
            useService.addUse(use);

            // 电表更新：用电量更新为0，电费更新为0，始码更新为止码
            meter.setMeterStartNum(meter.getMeterCurrentNum());
            meter.setMeterMoney(0.0);
            meter.setMeterNum(0.0);
            meterService.UpdateMeter(meter);
        }
    }

    /**
     * 发布电价定时任务，每月1号0点0分0秒执行一次
     * 每月电价默认为3元1°，管理员可以进行修改
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public void priceTask() {
        String month = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Price price = new Price();
        price.setPriceMoney(3.0);
        price.setPriceMonth(month);
        priceService.addPrice(price);
    }

}
