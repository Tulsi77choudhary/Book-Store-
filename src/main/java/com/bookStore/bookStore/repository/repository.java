package com.bookStore.bookStore.repository;

import com.bookStore.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<Book,Integer> {
}
