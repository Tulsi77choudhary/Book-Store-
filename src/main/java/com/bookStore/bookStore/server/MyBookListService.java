package com.bookStore.bookStore.server;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    // Object
    @Autowired
    private MyBookRepository myBook;

    public void saveMyBook(MyBookList book) {       //create a method

        myBook.save(book);
    }
    public List<MyBookList> getAllMyBook(){

        return myBook.findAll();
    }
    public void deleteById(int id){
        myBook.deleteById(id);
    }
}
