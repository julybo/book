package gh.book.dao;


import gh.book.model.MyBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MyBookMapper {

    MyBook findById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(MyBook record);

    int insertSelective(MyBook record);
}