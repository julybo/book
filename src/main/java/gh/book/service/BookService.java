package gh.book.service;

import gh.book.dao.BookCategoryMapper;
import gh.book.dao.BookMapper;
import gh.book.dao.MyBookMapper;
import gh.book.model.Book;
import gh.book.model.BookCategory;
import gh.book.model.MyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static java.lang.System.console;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookCategoryMapper bookCategoryMapper;

    @Autowired
    MyBookMapper myBookMapper;




    public List<Book> getAllBooks(){
        return bookMapper.selectAll();
    }

    public List<Book> getBooksByCid(Integer cid){
        return bookMapper.findAllByCategory(cid);
    }

    public void addOrUpdate(Book book) {
        Book book2 = bookMapper.findById(book.getId());
        if(book2 == null) {
            bookMapper.insert(book);
        }else {
            bookMapper.update(book);
        }
    }

    public void deleteById(Integer id) {
        bookMapper.deleteById(id);
    }

    public List<Book> listByCategory(Integer cid) {
        BookCategory category = bookCategoryMapper.findById(cid);
        return bookMapper.findAllByCategory(category.getId());
    }

    public List<Book> Search(String keywords) {
        return bookMapper.customQuery("%"+keywords + "%");
    }

    public Integer borrowBook(Book book){
        if(myBookMapper.findById(book.getId()) == null) {
            MyBook myBook = new MyBook();
            myBook.setId(book.getId());
            return myBookMapper.insert(myBook);
        }else {
           return  1;
        }
    }

    public Integer  cancelborrowBook(Book book) {
        return myBookMapper.deleteByPrimaryKey(book.getId());
    }

    public List<Book> getAllBorrow(){

        return  bookMapper.getAllBorrow();

    }

    public List<BookCategory> getAllBookCategory(){

        return  bookCategoryMapper.selectAll();

    }

}
