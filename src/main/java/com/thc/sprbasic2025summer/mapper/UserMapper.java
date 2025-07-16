package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.UserDto;
import java.util.List;

public interface UserMapper {
    //상세 조회를 위한 것
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    //목록을 위한 것!
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
}
