package org.shop.miaosha.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.shop.miaosha.Bean.Book;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao {
    @Select(" select * from book where id = #{id} ")
    Book getById(@Param("id") int id);
    @Insert(" insert into book(id, name, author) values( #{id}, #{name}, #{author)")
    int insert(Book book);
}
