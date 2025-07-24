package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatDto;

import java.util.List;

public interface ChatMapper {
    /**/
    ChatDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatDto.DetailResDto> list(ChatDto.ListReqDto param);
    List<ChatDto.DetailResDto> pagedList(ChatDto.PagedListReqDto param);
    int pagedListCount(ChatDto.PagedListReqDto param);
    List<ChatDto.DetailResDto> scrollList(ChatDto.ScrollListReqDto param);
}
