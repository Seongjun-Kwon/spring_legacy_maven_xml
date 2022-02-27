package com.tistory.modaljoa.mapper;

import com.tistory.modaljoa.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

//    @Select("SELECT * FROM tbl_board WHERE bno > 0")
    public List<BoardVO> getList();
}
