package gh.book.dao;

import gh.book.model.BookCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BookCategoryMapper {

    BookCategory findById(Integer id);

    List<BookCategory> selectAll();

    int insert(BookCategory record);

    int insertSelective(BookCategory record);
}