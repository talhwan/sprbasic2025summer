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
    public UserDto.LoginResDto login(UserDto.LoginReqDto param) {
        //1번 방법
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        return UserDto.LoginResDto.builder().done(user != null).build();
        /*
        //2번 방법!
        return UserDto.LoginResDto.builder().done(userMapper.login(param) != null).build();
        */
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        //혹시 아이디 중복인지 확인해줘..
        // 1번 방법
        User user = userRepository.findByUsername(param.getUsername());
        if(user != null){
            throw new RuntimeException("already exist");
        }
        /*
        //2번 방법
        UserDto.DetailResDto res = userMapper.username(UserDto.LoginReqDto.builder().username(param.getUsername()).build());
        if(res != null){
            throw new RuntimeException("already exist");
        }
        */
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
        return addList(userMapper.list(param));
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
    }

    public List<UserDto.DetailResDto> addList(List<UserDto.DetailResDto> list) {
        List<UserDto.DetailResDto> returnList = new ArrayList<>();
        for(UserDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(userMapper.pagedListCount(param));
        res.setList(addList(userMapper.pagedList(param)));
        return res;

        /*//한번에 볼 페이지수 부터 정리!
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

        //정렬 초기값 설정
        String orderby = "id";
        if(param.getOrderby() != null && !param.getOrderby().isEmpty()){
            orderby = param.getOrderby();
        }
        param.setOrderby(orderby);
        String orderway = "desc";
        if(param.getOrderway() != null && !param.getOrderway().isEmpty()){
            orderway = param.getOrderway();
        }
        param.setOrderway(orderway);*/
        /*DefaultDto.PagedListResDto res =
        DefaultDto.PagedListResDto.builder()
                .callpage(callpage)
                .perpage(perpage)
                .totalpage(totalPage)
                .totalcount(totalCount)
                .list(returnList)
                .build();*/
    }

    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param) {
        param.init();
        return addList(userMapper.scrollList(param));
    }
}
