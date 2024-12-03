package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.server.BookService;
import com.bookStore.bookStore.server.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private MyBookListService myBookService;
    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
       List<Book> list = service.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("/my_book")
    public String getMyBook(Model model){
        List<MyBookList>list= myBookService.getAllMyBook();
        model.addAttribute("book",list);
        return "myBook";
    }
    @RequestMapping("/my list/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=service.getBookById(id);
        MyBookList  mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBook(mb);
        return "redirect:/my_book";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id ,Model model){
         Book b =service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }
}