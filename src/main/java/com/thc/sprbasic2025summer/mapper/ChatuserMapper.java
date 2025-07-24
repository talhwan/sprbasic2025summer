package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatuserDto;

import java.util.List;

public interface ChatuserMapper {
    /**/
    ChatuserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatuserDto.DetailResDto> list(ChatuserDto.ListReqDto param);
    List<ChatuserDto.DetailResDto> pagedList(ChatuserDto.PagedListReqDto param);
    int pagedListCount(ChatuserDto.PagedListReqDto param);
    List<ChatuserDto.DetailResDto> scrollList(ChatuserDto.ScrollListReqDto param);
}
