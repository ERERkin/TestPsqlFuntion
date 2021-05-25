package com.example.testSQLFunction.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataWorkerImpl implements DataWorker {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void getCustomersByName(String name) {
        name = "SUka";
        String sql = "SELECT postgres.public.functions.update_emp(1,1,1);";
        String a = null;
        List<String> list = jdbcTemplate.query(sql, new Object[]{}, new CustomerRawMapper());
        System.out.println(list);
    }

}
