package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UmbController {

    public UmbController() { //odstranil som z argumentu kvoli chybam: List<Book> books, List<BorrowedBook> borrowings, List<User> users
        this.books = initBooks();

        this.users = initUsers();
    }

    private List<Book> books;
    private List<BorrowedBook> borrowings;
    private List<User> users;
    private BookService bookService;
    private BorrowedService borrowedService;

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

    private List<User> initUsers(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("adam");
        user1.setLastName("novy");
        user1.setEmail("random mail");

        users.add(user1);
        return users;
    }

    private List<Book> initBooks(){
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
    return bookService.getBook(bookId);
    }
    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @DeleteMapping("/api/book/{bookId}")
    public void DeleteBook(@PathVariable Integer bookId){
        bookService.DeleteBook(bookId);
    }
    @PutMapping("/api/book/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        bookService.updateBook(bookId, book);
    }




    //borrowings

    @PostMapping("/api/borrowings")
    public BorrowedBook getBorrowedBook(@PathVariable Integer id){
        return borrowedService.getBorrowings(id);
    }
    public Integer createBorrowing(@RequestBody int id, int bookId){
        BorrowedBook borrowed = new BorrowedBook();
        borrowed.setBorrower("borr");
        borrowed.setBook("abc");


        this.borrowings.add(borrowed);
        return this.borrowings.size()-1;
    }

    @GetMapping("/api/borrowings")
    public List<BorrowedBook> getBorrowings(@RequestParam(required = false) String bookAuthor){

        /*List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }
        Book book = new Book();*/

        return this.borrowings;
    }

    @GetMapping("/api/borrowing/{id}")
    public BorrowedBook getBorrowings(@PathVariable Integer id){
        return borrowedService.getBorrowings(id);
    }

    @DeleteMapping("/api/borrowings/{id}")
    public void DeleteBorrowing(@PathVariable Integer id){
        borrowedService.DeleteBorrowing(id);
    }


}
