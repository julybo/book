package gh.book.dao;

import gh.book.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Component
@Mapper
public interface BookMapper {


    Book findById(Integer id);

    List<Book> selectAll();

    List<Book> customQuery(String where);

    List<Book> findAllByCategory(Integer cid);

    List<Book>   getAllBorrow();



    int insert(Book record);

    int update(Book record);

    int insertSelective(Book record);

    void deleteById(Integer id);
}