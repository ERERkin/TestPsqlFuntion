package com.example.testSQLFunction.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCTemp {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void doSomething(String name, int age, double salary) {
        final SimpleJdbcCall updateEmployeeCall = new SimpleJdbcCall(jdbcTemplate)
                .withoutProcedureColumnMetaDataAccess()

                .withSchemaName("public")
                .withCatalogName("functions")
                .withFunctionName("update_emp")
                .declareParameters(
                        new SqlOutParameter("RETURN", Types.INTEGER),
//                        new SqlParameter("p_id", Types.NUMERIC),
                        new SqlParameter("p_name", Types.VARCHAR),
                        new SqlParameter("p_age", Types.INTEGER),
                        new SqlParameter("p_salary", Types.INTEGER)
                )
                .withReturnValue();
        ;
        MapSqlParameterSource inParams = new MapSqlParameterSource();
        inParams.addValue("p_id", null);
        inParams.addValue("p_name", "John");
        inParams.addValue("p_age", 28);
        inParams.addValue("p_salary", 150000);

//        final Map<String, Object> params = new HashMap<>();
//        params.put("p_id", null);
//        params.put("p_name", "John");
//        params.put("p_age", 28);
//        params.put("p_salary", 150000);

        final Map<String, Object> result = updateEmployeeCall.execute(inParams);
        System.out.println(result.get("returnvalue"));
    }
}
