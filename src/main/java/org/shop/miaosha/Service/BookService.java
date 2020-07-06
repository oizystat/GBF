package org.shop.miaosha.Service;

import org.shop.miaosha.Bean.Book;
import org.shop.miaosha.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public Book getById(int id){
        return bookDao.getById(id);
    }
    public int insert(Book book){
        return bookDao.insert(book);
    }
}
