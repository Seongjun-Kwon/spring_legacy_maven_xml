package com.tistory.modaljoa.controller;

import com.tistory.modaljoa.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample/")
@Log4j
public class SampleController {

    @GetMapping("/json")
    public @ResponseBody
    SampleDTO json() {
        log.info("/json-------------------------");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

    @GetMapping("/exUpload")
    public String exUpload() {
        log.info("/exUpload-------------------------");

        return "sample/exUpload";
    }
}
