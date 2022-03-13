package com.tistory.modaljoa.mapper;

import com.tistory.modaljoa.domain.Criteria;
import com.tistory.modaljoa.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyVO reply);

    public ReplyVO read(Long rno);

    public int delete(Long rno);

    public int update(ReplyVO reply);

    public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
