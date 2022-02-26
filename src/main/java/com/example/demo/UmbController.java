package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UmbController {

    public UmbController() { //odstranil som z argumentu kvoli chybam: List<Book> books, List<BorrowedBook> borrowings, List<User> users
        this.books = initBooks();
        this.borrowings = initBorrowed();
        this.users = initUsers();
    }

    private List<Book> books;
    private List<BorrowedBook> borrowings;
    private List<User> users;

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

    private List<BorrowedBook> initBorrowed(){
        List<BorrowedBook> borrowings = new ArrayList<>();
        BorrowedBook borrowed1 = new BorrowedBook();

        borrowed1.setBook(books.get(0));
        borrowed1.setBorrower(new User()); //pokus
        borrowed1.setId(1);

        borrowings.add(borrowed1);

        return borrowings;
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




    //borrowings

    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody int id, int bookId){
        BorrowedBook borrowed = new BorrowedBook();
        borrowed.setBorrower(users.get(id));
        borrowed.setBook(books.get(bookId));


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
        return this.borrowings.get(id);
    }

    @DeleteMapping("/api/borrowings/{id}")
    public void DeleteBorrowing(@PathVariable Integer id){
        this.borrowings.remove(this.borrowings.get(id));
    }


}
