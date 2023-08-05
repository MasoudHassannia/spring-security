package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Notice;
import com.example.springsecuritybasic.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public List<Notice> findAllActiveNotices(){
        return noticeRepository.findAllActiveNotices();
    }
}
