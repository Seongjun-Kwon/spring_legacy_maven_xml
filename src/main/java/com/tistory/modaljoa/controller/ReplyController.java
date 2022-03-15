package com.tistory.modaljoa.controller;

import com.tistory.modaljoa.domain.Criteria;
import com.tistory.modaljoa.domain.ReplyPageDTO;
import com.tistory.modaljoa.domain.ReplyVO;
import com.tistory.modaljoa.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/replies")
@RestController
@AllArgsConstructor
@Log4j
public class ReplyController {

    private ReplyService service;

    @PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO reply) {

        log.info("ReplyVO: " + reply);

        return service.register(reply) == 1
                ? new ResponseEntity<String>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, "application/json;charset=UTF-8"})
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {

        log.info("get: " + rno);

        return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {

        log.info("remove: " + rno);

        return service.remove(rno) == 1
                ? new ResponseEntity<String>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "/{rno}",
            consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@RequestBody ReplyVO reply, @PathVariable("rno") Long rno) {

        reply.setRno(rno);

        log.info("rno: " + rno);
        log.info("modify: " + reply);

        return service.modify(reply) == 1
                ? new ResponseEntity<String>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//	 @GetMapping(value = "/pages/{bno}/{page}",
//			 produces = {
//					 MediaType.APPLICATION_XML_VALUE,
//					 MediaType.APPLICATION_JSON_UTF8_VALUE })
//	 public ResponseEntity<List<ReplyVO>> getList(
//			 @PathVariable("page") int page,
//			 @PathVariable("bno") Long bno) {
//
//
//		 log.info("getList.................");
//		 Criteria cri = new Criteria(page,10);
//		 log.info(cri);
//
//	 return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
//	 }

    @GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, "application/json;charset=UTF-8"})
    public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {

        Criteria cri = new Criteria(page, 10);

        log.info("get Reply List bno: " + bno);

        log.info("cri: " + cri);

        return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, bno), HttpStatus.OK);
    }
}
