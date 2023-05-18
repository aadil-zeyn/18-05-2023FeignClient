package com.UST.BookServicesFeign.Contrller;

import com.UST.BookServicesFeign.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;
    @GetMapping("/data")
    public String getBookDate(){
        return "data of BOOK-SERVICE, Running on port: "+environment.getProperty("local.server.port");
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return new Book(id,"Heads of  java",500.76);
    }
    @GetMapping("/all")
    public List<Book> getAll(){
        return List.of(
                new Book(501,"Head first java",500.76),
                new Book(502,"Tails first java",400.76),
                new Book(503,"Strings in java",330.96)
        );
    }
    @GetMapping("/entity")
    public ResponseEntity<String> getEntityDate(){
        return new ResponseEntity<String>("Hello from BookRestController", HttpStatus.OK);
    }
}
