package gh.book.controller;


import com.github.pagehelper.PageHelper;
import gh.book.dao.BookCategoryMapper;
import gh.book.dao.BookMapper;
import gh.book.model.Book;
import gh.book.model.BookCategory;
import gh.book.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;



@CrossOrigin
@RestController
@RequestMapping(value="/api")
@Api(value="/api",description = "图书接口")
public class BookController {


    @Autowired
    BookService bookService;

    private static  final Logger logger= LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value="/books/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ApiOperation(value="获得所有的图书", notes="失败返回null")
    public List<Book> listBooks(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {


        logger.debug("开始进行分页查询");
        logger.debug("查询方法：SelectAll，查询参数:pageNum=%S,pageSize=%S",pageNum,pageSize);
        if (pageNum!=null && pageSize!=null
                && pageNum!=0 && pageSize!=0){
            PageHelper.startPage(pageNum,pageSize);
        }
        try {
            return  bookService.getAllBooks();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            logger.error("分页查询结束，查询失败");
            return  null;
        }
    }


    @RequestMapping(value="/bookCategorys",method = RequestMethod.GET)
    @ApiOperation(value="获得所有的图书类别", notes="失败返回null")
    public List<BookCategory> listBookCategorys()
    {
        return bookService.getAllBookCategory();
    }

    @RequestMapping(value="/search",method = RequestMethod.POST)
    @ApiOperation(value="根据书名和作者搜索图书", notes="失败返回null")
    @ApiImplicitParam(paramType="query", name = "jsonObject", value = "图书标题", required = true, dataType = "String")
    public List<Book> searchResult( @RequestBody JSONObject jsonObject) {
        String keywords = jsonObject.get("keywords").toString();
        if ("".equals(keywords)) {
            return bookService.getAllBooks();
        } else {
            return bookService.Search(keywords);
        }
    }






    @RequestMapping(value="/categories/{cid}/books",method = RequestMethod.GET)
    @ApiOperation(value="根据图书分类id获得所有的图书", notes="失败返回null")
    @ApiImplicitParam(paramType="query", name = "cid", value = "图书分类id", required = true, dataType = "Integer")
    public List<Book> listByCategory(@PathVariable("cid") Integer cid) {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return listBooks(1,12);
        }
    }



    @RequestMapping(value="/admin/content/books/addOrUpdate",method = RequestMethod.POST)
    @ApiOperation(value="更新或插入图书", notes="失败返回null")
    @ApiImplicitParam(paramType="query", name = "book", value = "图书分类id", required = true, dataType = "gh.book.dao.Book")
    public Book addOrUpdateBooks(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return book;
    }


    @RequestMapping(value="/admin/content/books/delete",method = RequestMethod.POST)
    @ApiOperation(value="删除图书", notes="失败返回null")
    @ApiImplicitParam(paramType="query", name = "book", value = "图书", required = true, dataType = "gh.book.dao.Book")
    public void deleteBook(@RequestBody Book book) {
        bookService.deleteById(book.getId());
    }





    @RequestMapping(value="/admin/content/books/borrow",method = RequestMethod.POST)
    @ApiOperation(value="用户借阅图书", notes="失败返回false")
    @ApiImplicitParam(paramType="query", name = "book", value = "图书", required = true, dataType = "gh.book.dao.Book")
    public boolean borrow(@RequestBody Book book) {

        return bookService.borrowBook(book) > 0 ? true:false;
    }


    @RequestMapping(value="/admin/content/books/cancelBorrow",method = RequestMethod.POST)
    @ApiOperation(value="用户取消借阅图书", notes="失败返回false")
    @ApiImplicitParam(paramType="query", name = "book", value = "图书", required = true, dataType = "gh.book.dao.Book")
    public boolean cancelBorrow(@RequestBody Book book) {
        return bookService.cancelborrowBook(book)> 0 ? true:false;
    }

    @RequestMapping(value="/admin/content/books/getAllBorrow",method = RequestMethod.GET)
    @ApiOperation(value="获得用户所借阅图书", notes="失败返回null")
    public List<Book> getAllBorrow() {
        return bookService.getAllBorrow();
    }



}
