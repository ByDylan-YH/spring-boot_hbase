package com.hbase.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author:BYDylan
 * Date:2020/9/24
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "hbase.zookeeper")
@ConfigurationPropertiesScan
public class HBaseConfig {
    private String quorum;
    private String port;
    private Connection connection = null;

    private void init() {
        System.setProperty("HADOOP_USER_HOME", "root");
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", quorum.toString());
        try {
            connection = ConnectionFactory.createConnection(conf);
            System.out.println(conf.get("hbase.zookeeper.quorum"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean("hbaseConnect")
    @Qualifier("hbaseConnect")
    public Connection connection() {
        init();
        return connection;
    }
}