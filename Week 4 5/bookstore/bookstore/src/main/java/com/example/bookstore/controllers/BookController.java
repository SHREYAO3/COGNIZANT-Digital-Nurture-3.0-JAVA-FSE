package com.example.bookstore.controllers;

import com.example.bookstore.models.BookEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private List<BookEntity> booklist = new ArrayList<>();//to temporarily store data to show the working of the API endpoints
    //represents all the books present in the bookstore

    //get mapping /books to get all books data
    @GetMapping
    public ResponseEntity<List<BookEntity>> getBooks(){
        return new ResponseEntity<List<BookEntity>>(booklist, HttpStatus.OK);
    }

    //get endpoint to find a book by given ISBN iterates over the arraylist and matches the ISBN of each until found or else returns null
    @GetMapping("/byid/{id}")
    public ResponseEntity<BookEntity> getBookByISBN(@PathVariable String id){
        BookEntity res = null;
        for (BookEntity b: booklist) {
            if(b.getIsbn().equals(id)){
                res = b;
            }
        }
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    //get mapping to search books by title or author (requires at least one) and returns the books
    // (returns empty arraylist if nothing is specified with status code not acceptable)
    //returns empty arraylist with status code not found if the specified book is not found by query parameters
    @GetMapping("/byTitleAuthor")
    public ResponseEntity<List<BookEntity>> getBooksByTitleOrAuthor(@RequestParam(required = false) String title, @RequestParam(required = false) String author){
        List<BookEntity> res = new ArrayList<>();
        if(title==null && author==null)return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
       if(author==null){
           for (BookEntity b :booklist) {
                if(b.getTitle().equals(title)){
                    res.add(b);
                }
           }
       }
       else if (title==null) {
           for (BookEntity b :booklist) {
               if(b.getAuthor().equals(author)){
                   res.add(b);
               }
           }
       }
       else{
           for (BookEntity b :booklist) {
               if(b.getAuthor().equals(author) && b.getTitle().equals(title)){
                   res.add(b);
               }
           }
       }
       if(res.isEmpty())return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);

       return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    //post mapping to add a new book to the book list that is all the books in the bookstore
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookEntity book){
        booklist.add(book);
        return new ResponseEntity<>("book successfully added",HttpStatus.CREATED);
    }

    //put mapping to update existing book data
    @PutMapping
    public ResponseEntity<String> updateBook(@RequestBody BookEntity book){
        for (BookEntity b :booklist) {
           if(b.getIsbn().equals(book.getIsbn())){
               booklist.remove(b);
               booklist.add(book);
               return new ResponseEntity<>("book updated",HttpStatus.CREATED);
           }
        }
        return new ResponseEntity<>("no such book exists try creating a new one",HttpStatus.NOT_FOUND);
    }

    //delete mapping to remove a book from the booklist by isbn
    //returns null if not found any book in the booklist by given isbn
    @DeleteMapping("/{id}")
    public ResponseEntity<BookEntity> removeBookByISBN(@PathVariable String id){
        for (BookEntity b :booklist) {
            if(b.getIsbn().equals(id)){
                booklist.remove(b);
                return new ResponseEntity<>(b,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


}
