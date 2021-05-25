package com.example.testSQLFunction.service;

import com.example.testSQLFunction.db.DataWorker;
import com.example.testSQLFunction.db.JDBCTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Shedule {
    @Autowired
    JDBCTemp jdbcTemp;

    @Autowired
    DataWorker dataWorker;

    int a = 0;

    @Scheduled(cron = "* * * * * * ")
    void doShedule(){
//        jdbcTemp.doSomething("One" + a, a, a * 100);
        dataWorker.getCustomersByName("suka");
    }
}
