package by.bsu.booksearchsoap.controller;
import by.bsu.booksearchsoap.client.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static by.bsu.booksearchsoap.util.Constants.*;

@Controller
public class FrontController {

    @GetMapping(value = "/books")
    public ModelAndView getAllBooks() throws Exception{
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        Book[] books = service.viewAllBooks();
        ModelAndView model = new ModelAndView(MAIN);
        model.addObject(BOOKS, books);
        return model;
    }

    @GetMapping(value = "/books/{id}")
    public ModelAndView getCertainBook(@PathVariable(ID_PARAM) String bookId) throws Exception{
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        long id = Long.parseLong(bookId);
        Book book = service.findBookById(id);
        ModelAndView model = new ModelAndView(SINGLE_BOOK);
        model.addObject(BOOK_ITEM, book);
        return model;
    }

    @GetMapping(value = "/books/add")
    public ModelAndView addBookPage() throws Exception{
        return new ModelAndView(ADD_BOOK);
    }

    @PostMapping(value = "/books/add")
    public ModelAndView addBook(@RequestParam( name = TITLE_PARAM) String title,
                                @RequestParam( name = AUTHOR_ID_PARAM) long authorId,
                                @RequestParam( name = PUBLISHING_YEAR) int publishingYear,
                                @RequestParam( name = DESCRIPTION_PARAM) String description,
                                @RequestParam( name = GENRE_PARAM) String genre) throws Exception{
        BookDTO bookDTO = new BookDTO(0, title, publishingYear, description, genre, authorId);
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        service.addBook(bookDTO);
        Book[] books = service.viewAllBooks();
        ModelAndView model = new ModelAndView(MAIN);
        model.addObject(BOOKS, books);
        return model;
    }

    @GetMapping(value = "/books/{id}/edit")
    public ModelAndView editBookView(@PathVariable(ID_PARAM) String bookId) throws Exception{
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        long id = Long.parseLong(bookId);
        Book book = service.findBookById(id);
        ModelAndView model = new ModelAndView(EDIT_BOOK);
        model.addObject(BOOK_ITEM, book);
        return model;
    }

    @PostMapping(value = "/books/{id}/edit")
    public ModelAndView editBook(@RequestParam( name = TITLE_PARAM) String title,
                                 @RequestParam( name = AUTHOR_ID_PARAM) long authorId,
                                 @RequestParam( name = PUBLISHING_YEAR) int publishingYear,
                                 @RequestParam( name = DESCRIPTION_PARAM) String description,
                                 @RequestParam( name = GENRE_PARAM) String genre,
                                 @PathVariable(ID_PARAM) String bookId) throws Exception{
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        long id = Long.parseLong(bookId);
        BookDTO bookDTO = new BookDTO(id, title, publishingYear, description, genre, authorId);
        service.updateBook(bookDTO);
        Book[] books = service.viewAllBooks();
        ModelAndView model = new ModelAndView(MAIN);
        model.addObject(BOOKS, books);
        return model;
    }

    @GetMapping(value = "/books/{id}/delete")
    public ModelAndView deleteBook(@PathVariable(ID_PARAM) String bookId) throws Exception{
        IBookService service = new BookServiceImplServiceLocator().getBookServiceImplPort();
        long id = Long.parseLong(bookId);
        service.deleteBook(id);
        return new ModelAndView(MAIN);
    }


    /* For authors */

    @GetMapping(value = "/authors")
    public ModelAndView getAllAuthors() throws Exception{
        IAuthorService service = new AuthorServiceImplServiceLocator().getAuthorServiceImplPort();
        Author[] authors = service.viewAllAuthors();
        ModelAndView model = new ModelAndView(MAIN);
        model.addObject(AUTHORS, authors);
        return model;
    }

    @GetMapping(value = "/authors/{id}")
    public ModelAndView getCertainAuthor(@PathVariable(ID_PARAM) String authorId ) throws Exception{
        IAuthorService service = new AuthorServiceImplServiceLocator().getAuthorServiceImplPort();
        long id = Long.parseLong(authorId);
        Author author = service.findAuthorById(id);
        ModelAndView model = new ModelAndView(SINGLE_AUTHOR);
        model.addObject(AUTHOR_ITEM, author);
        return model;
    }

    @GetMapping(value = "/authors/add")
    public ModelAndView addAuthorPage() throws Exception{
        return new ModelAndView(ADD_AUTHOR);
    }

    @PostMapping(value = "/authors/add")
    public ModelAndView addAuthor(@RequestParam( name = FULL_NAME_PARAM) String fullName,
                                  @RequestParam( name = BIRTH_YEAR_PARAM) int birthYear,
                                  @RequestParam( name = BIRTH_COUNTRY_PARAM) String birthCountry,
                                  @RequestParam( name = BIOGRAPHY_PARAM) String biography) throws Exception{
        Author author = new Author(0, fullName, birthYear, birthCountry, biography);
        IAuthorService service = new AuthorServiceImplServiceLocator().getAuthorServiceImplPort();
        service.addAuthor(author);
        Author[] authors = service.viewAllAuthors();
        ModelAndView model = new ModelAndView(MAIN);
        model.addObject(AUTHORS, authors);
        return model;
    }

    @GetMapping(value = "/authors/{id}/edit")
    public ModelAndView editAuthorView(@PathVariable(ID_PARAM) String authorId) throws Exception{
        IAuthorService service = new AuthorServiceImplServiceLocator().getAuthorServiceImplPort();
        long id = Long.parseLong(authorId);
        Author author = service.findAuthorById(id);
        ModelAndView model = new ModelAndView(EDIT_AUTHOR);
        model.addObject(AUTHOR_ITEM, author);
        return model;
    }

    @PostMapping(value = "/authors/{id}/edit")
    public ModelAndView editAuthor(@RequestParam( name = FULL_NAME_PARAM) String fullName,
                                   @RequestParam( name = BIRTH_YEAR_PARAM) int birthYear,
                                   @RequestParam( name = BIRTH_COUNTRY_PARAM) String birthCountry,
                                   @RequestParam( name = BIOGRAPHY_PARAM) String biography,
                                 @PathVariable(ID_PARAM) String authorId) throws Exception{
        IAuthorService service = new AuthorServiceImplServiceLocator().getAuthorServiceImplPort();
        long id = Long.parseLong(authorId);
        Author author = new Author(id, fullName, birthYear, birthCountry, biography);
        service.updateAuthor(author);
        ModelAndView model = new ModelAndView(SINGLE_AUTHOR);
        model.addObject(AUTHOR_ITEM, author);
        return model;
    }
}
