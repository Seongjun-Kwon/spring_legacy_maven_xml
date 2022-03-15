package com.tistory.modaljoa.service;

import com.tistory.modaljoa.domain.Criteria;
import com.tistory.modaljoa.domain.ReplyPageDTO;
import com.tistory.modaljoa.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVO reply);

    public ReplyVO get(Long rno);

    public int remove(Long rno);

    public int modify(ReplyVO reply);

    public List<ReplyVO> getList(Criteria cri, Long bno);

    public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
