package com.emi2c.mybatis.quartz;

import com.emi2c.mybatis.config.annotation.Operating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/task")
@RestController
public class QuartzController {

    @Operating(type = "START")
    @GetMapping("/start")
    public void task() throws Exception {
        QuartzJobManager.getInstance().addJob(DemoQuartz.class, "demo", "test_group", "*/55 * * * * ?");
        QuartzJobManager.getInstance().addJob(QueryQuartz.class, "query", "test_group", "*/10 * * * * ?");
        QuartzJobManager.getInstance().addJob(OperatingQuartz.class, "operating", "test_group", "*/10 * * * * ?");
    }

}
