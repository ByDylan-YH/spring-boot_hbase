package com.hbase;

import com.hbase.service.HBaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHbaseApplication.class)
class SpringBootHbaseApplicationTests {
    @Autowired
    private HBaseService hbaseService;

    @Test
    void createNameSpace() {
        hbaseService.createNameSpace("SpringBoot");
//        try {
//            hbaseService.admin.deleteNamespace("SpringBoot");
//        } catch (IOException e) {
//            log.error("创建名称空间失败: {}",e.getMessage());
//        }
    }

}
