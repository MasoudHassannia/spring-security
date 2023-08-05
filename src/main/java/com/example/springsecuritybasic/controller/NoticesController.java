package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Notice;
import com.example.springsecuritybasic.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private NoticeService noticeService;


    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> noticeList = noticeService.findAllActiveNotices();
        if(!noticeList.isEmpty())
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(noticeList);
        else return null;

    }

}
