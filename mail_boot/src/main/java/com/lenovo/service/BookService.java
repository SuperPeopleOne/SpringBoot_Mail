package com.lenovo.service;

import com.lenovo.dao.BookDao;
import com.lenovo.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Service
public class BookService {

    @Resource
    private BookDao bookDao;

    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Book> getList(){
        return bookDao.getList();
    }

}
