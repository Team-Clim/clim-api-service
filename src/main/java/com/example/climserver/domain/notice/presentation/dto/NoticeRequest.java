package com.example.climserver.domain.notice.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeRequest {
    private String title;
    private String contents;
}
