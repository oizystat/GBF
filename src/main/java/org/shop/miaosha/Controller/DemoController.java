package org.shop.miaosha.Controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.shop.miaosha.Bean.Book;
import org.shop.miaosha.Bean.Result;
import org.shop.miaosha.Service.BookService;
import org.shop.miaosha.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    BookService bookService = new BookService();
    @Autowired
    RedisService redisService;
    @RequestMapping("/hi")
    @ResponseBody  //不然会被mvc检测为返回view然后无法解析
    public Object home(){
        return Result.success("it's ok");
    }

    @RequestMapping("/errortest")
    @ResponseBody
    public Object error(){
        return Result.error(500,"errortest");
    }

    @RequestMapping("/getbook")
    @ResponseBody
    public Object getBook(){
        Book b ;

        try{
            b =bookService.getById(1);
        }catch (Exception e){
            e.printStackTrace();
            return "sql error";
        }
        return b;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int inserttest(){
        Book b = new Book();
        b.setId(14);
        b.setAuthor("13124124");
        b.setName("lsh");
        return  bookService.insert(b);
    }

    @RequestMapping("/redisget")
    @ResponseBody
    public Result<String> redisget(){
//        boolean b = redisService.set("redistest",  "hithereisredistest");
        String s = redisService.get("redistest", String.class);
        return Result.success(s);
    }
}
