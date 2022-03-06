package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;
    private List<BorrowedBook> borrowings;
    private List<User> users;
    private BookService bookService;

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




    public Book getBook(@PathVariable Integer bookId){
        return this.books.get(bookId);
    }

    public Integer createBook(@RequestBody Book book){
        this.books.add(book);
        return this.books.size()-1;
    }
    public void DeleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAuthor(book.getAuthor());
    }




    //borrowings






    // public List<BorrowedBook> getBorrowings(@RequestParam(required = false) String bookAuthor){

        /*List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equals(bookAuthor)){
                filteredBooks.add(book);
            }
        }
        Book book = new Book();*/

     //   return this.borrowings;
  //  }

  //  public static BorrowedBook getBorrowings(@PathVariable Integer id){
  //      return this.borrowings.get(id);
  //  }

  //  public void DeleteBorrowing(@PathVariable Integer id){
  //      this.borrowings.remove(this.borrowings.get(id));
   // }

}


