package com.lenovo.service;

import com.lenovo.config.TargetDataSource;
import com.lenovo.dao.DemoDao;
import com.lenovo.entity.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Service
public class DemoService {

    @Resource
    private DemoDao demoDao;

    /**
     * 指定数据源
     * @return
     */
    @TargetDataSource("ds1")
    public List<Demo> getListByDsFirst(){
        return demoDao.getListByDsFirst();
    }

}
