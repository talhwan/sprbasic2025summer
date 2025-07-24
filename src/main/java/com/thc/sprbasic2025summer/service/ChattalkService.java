package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.ChattalkDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChattalkService {
    /**/
    DefaultDto.CreateResDto create(ChattalkDto.CreateReqDto param);
    void update(ChattalkDto.UpdateReqDto param);
    void delete(ChattalkDto.UpdateReqDto param);
    ChattalkDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChattalkDto.DetailResDto> list(ChattalkDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(ChattalkDto.PagedListReqDto param);
    List<ChattalkDto.DetailResDto> scrollList(ChattalkDto.ScrollListReqDto param);
}