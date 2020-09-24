package com.hbase;

import com.hbase.config.HBaseConfig;
import com.hbase.tool.HBaseTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringBootHbaseApplicationTests {

    @Autowired
    private HBaseConfig hbaseConfig;

    @Autowired
    private HBaseTools hbaseTools;

    @Test
    void getHbaseConfig() {
        System.out.println(hbaseConfig);
    }

    @Test
    void createNameSpace() {
//        hbaseTools.createNameSpace("SpringBoot");
        try {
            hbaseTools.admin.deleteNamespace("SpringBoot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
