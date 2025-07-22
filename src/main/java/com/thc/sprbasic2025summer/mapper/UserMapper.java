package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.UserDto;
import java.util.List;

public interface UserMapper {
    UserDto.DetailResDto username(UserDto.LoginReqDto param);
    UserDto.DetailResDto login(UserDto.LoginReqDto param);
    /**/
    //상세 조회를 위한 것
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    //목록을 위한 것!
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    //페이징 처리를 위한 것
    List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto param);
    int pagedListCount(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}
