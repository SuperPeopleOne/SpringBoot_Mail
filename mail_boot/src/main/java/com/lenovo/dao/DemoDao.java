package com.lenovo.dao;

import com.lenovo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Service
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 指定数据源
     * 在对应的service进行指定;
     * @return
     */
    public List<Demo> getListByDsFirst(){
        String sql = "select id,user,pwd from demo";
        return (List<Demo>)jdbcTemplate.query(sql, new RowMapper<Demo>(){
            @Override
            public Demo mapRow(ResultSet resultSet,int rowNum) throws SQLException {
                Demo demo = new Demo();
                demo.setId(resultSet.getLong("id"));
                demo.setUser(resultSet.getString("user"));
                demo.setPwd(resultSet.getString("pwd"));
                return demo;
            }
        });
    }

}
