package com.example.climserver.domain.notice.service;

import com.example.climserver.domain.notice.domain.Notice;
import com.example.climserver.domain.notice.domain.repository.NoticeRepository;
import com.example.climserver.domain.notice.presentation.dto.NoticeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NoticeCreateService {
    private final NoticeRepository noticeRepository;

    public void createNotice(NoticeRequest noticeRequest){
        noticeRepository.save(
                Notice.builder()
                        .title(noticeRequest.getTitle())
                        .contents(noticeRequest.getContents())
                        .now(LocalDateTime.now())
                        .build()
        );
    }
}
