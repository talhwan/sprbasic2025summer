package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.User;
import com.thc.sprbasic2025summer.dto.UserDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.mapper.UserMapper;
import com.thc.sprbasic2025summer.repository.UserRepository;
import com.thc.sprbasic2025summer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ user.setDeleted(param.getDeleted()); }
        if(param.getPassword() != null){ user.setPassword(param.getPassword()); }
        if(param.getName() != null){ user.setName(param.getName()); }
        if(param.getPhone() != null){ user.setPhone(param.getPhone()); }
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        UserDto.DetailResDto res = userMapper.detail(param);
        return res;
        /*
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return UserDto.DetailResDto.builder().id(user.getId())
                .deleted(user.getDeleted()).createdAt(user.getCreatedAt()).modifiedAt(user.getModifiedAt())
                .username(user.getUsername()).name(user.getName()).phone(user.getPhone())
                .build();
        */
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> resultList = new ArrayList<>();
        List<UserDto.DetailResDto> list = userMapper.list(param);
        for(UserDto.DetailResDto each : list){
            resultList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        /*
        List<User> list = userRepository.findAll();
        for(User each : list){
            boolean isSerached = true;
            if(param.getDeleted() != null){
                System.out.println("param.getDeleted() not null?");
                if(each.getDeleted() != param.getDeleted()){
                    isSerached = false;
                    System.out.println("param.getDeleted() false");
                }
            }
            if(param.getName() != null && !param.getName().isEmpty()){
                System.out.println("param.getName() not null?");
                if(!each.getName().contains(param.getName())){
                    isSerached = false;
                    System.out.println("param.getName() : " + isSerached);
                }
            }
            if(param.getPhone() != null && !param.getPhone().isEmpty()){
                System.out.println("param.getPhone() not null?");
                if(!each.getPhone().contains(param.getPhone())){
                    isSerached = false;
                    System.out.println("param.getPhone() : " + isSerached);
                }
            }
            if(isSerached){
                resultList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
            }
        }
        */
        return resultList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        int totalCount = userMapper.pagedListCount(param);
        //한번에 볼 페이지수 부터 정리!
        int perpage = 10;
        if(param.getPerpage() != null){
            perpage = param.getPerpage();
        }
        if(perpage < 2){
            perpage = 2;
        }
        param.setPerpage(perpage);

        // 전체 글 갯수를 활용해서 전체 페이지수 정리!
        int totalPage = totalCount / perpage;
        if(totalCount % perpage > 0){
            totalPage++;
        }

        // 내 요청 페이지가 정상적인지 검토!
        int callpage = 1;
        if(param.getCallpage() != null){
            callpage = param.getCallpage();
        }
        if(callpage > totalPage){
            callpage = totalPage;
        }
        if(callpage < 1){
            callpage = 1;
        }
        param.setCallpage(callpage);

        // 순번 계산!
        int offset = (callpage - 1) *  perpage;
        param.setOffset(offset);

        List<UserDto.DetailResDto> list = userMapper.pagedList(param);
        List<UserDto.DetailResDto> returnList = new ArrayList<>();
        for(UserDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }

        DefaultDto.PagedListResDto res =
        DefaultDto.PagedListResDto.builder()
                .callpage(callpage)
                .perpage(perpage)
                .totalpage(totalPage)
                .totalcount(totalCount)
                .list(returnList)
                .build();

        return res;
    }
}
