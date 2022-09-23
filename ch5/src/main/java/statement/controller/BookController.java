package statement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import statement.service.BookService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }
}
