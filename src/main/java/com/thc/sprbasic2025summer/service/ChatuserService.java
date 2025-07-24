package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatuserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatuserService {
    /**/
    DefaultDto.CreateResDto create(ChatuserDto.CreateReqDto param);
    void update(ChatuserDto.UpdateReqDto param);
    void delete(ChatuserDto.UpdateReqDto param);
    ChatuserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatuserDto.DetailResDto> list(ChatuserDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(ChatuserDto.PagedListReqDto param);
    List<ChatuserDto.DetailResDto> scrollList(ChatuserDto.ScrollListReqDto param);
}