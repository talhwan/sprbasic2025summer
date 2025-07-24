package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {
    /**/
    DefaultDto.CreateResDto create(ChatDto.CreateReqDto param);
    void update(ChatDto.UpdateReqDto param);
    void delete(ChatDto.UpdateReqDto param);
    ChatDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatDto.DetailResDto> list(ChatDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(ChatDto.PagedListReqDto param);
    List<ChatDto.DetailResDto> scrollList(ChatDto.ScrollListReqDto param);
}