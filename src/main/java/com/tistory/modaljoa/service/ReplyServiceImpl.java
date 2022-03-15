package com.tistory.modaljoa.service;

import com.tistory.modaljoa.domain.Criteria;
import com.tistory.modaljoa.domain.ReplyPageDTO;
import com.tistory.modaljoa.domain.ReplyVO;
import com.tistory.modaljoa.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {

    private ReplyMapper mapper;

    @Override
    public int register(ReplyVO reply) {

        log.info("register: " + reply);

        return mapper.insert(reply);
    }

    @Override
    public ReplyVO get(Long rno) {

        log.info("get: " + rno);

        return mapper.read(rno);
    }

    @Override
    public int remove(Long rno) {

        log.info("remove: " + rno);

        return mapper.delete(rno);
    }

    @Override
    public int modify(ReplyVO reply) {

        log.info("modify: " + reply);

        return mapper.update(reply);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {

        log.info("get List: " + bno);

        return mapper.getListWithPaging(cri, bno);
    }

    @Override
    public ReplyPageDTO getListPage(Criteria cri, Long bno) {

        return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
    }
}
