package org.shop.miaosha.Bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
}
