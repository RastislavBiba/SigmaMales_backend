package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UmbController {

    public UmbController(List<Book> books) {
        this.books = init();
    }

    private List<Book> books;

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor){
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }
        Book book = new Book();
        return this.books;
    }


    private List<Book> init(){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setAuthor("Arthur");
        book1.setTitle("Study in Red");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Michal");
        book2.setTitle("Pisem knihu");
        books.add(book2);

        return books;
    }

    @GetMapping("/api/book/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
    return this.books.get(bookId);
    }
    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        this.books.add(book);
        return this.books.size()-1;
    }
    @DeleteMapping("/api/book/{bookId}")
    public void DeleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }
    @PutMapping("/api/book/{bookId}")
    public void updateteBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAuthor(book.getAuthor());
    }






}
