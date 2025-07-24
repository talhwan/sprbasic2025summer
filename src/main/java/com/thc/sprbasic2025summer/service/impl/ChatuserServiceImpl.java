package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Chatuser;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatuserDto;
import com.thc.sprbasic2025summer.mapper.ChatuserMapper;
import com.thc.sprbasic2025summer.repository.ChatuserRepository;
import com.thc.sprbasic2025summer.service.ChatuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatuserServiceImpl implements ChatuserService {

    final ChatuserRepository chatuserRepository;
    final ChatuserMapper chatuserMapper;

    /**/

    @Override
    public DefaultDto.CreateResDto create(ChatuserDto.CreateReqDto param) {
        Chatuser chatuser = chatuserRepository.findByChatIdAndUserId(param.getChatId(), param.getUserId());
        if(chatuser != null){
            return chatuser.toCreateResDto();
        }
        return chatuserRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(ChatuserDto.UpdateReqDto param) {
        Chatuser chatuser = chatuserRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ chatuser.setDeleted(param.getDeleted()); }
        chatuserRepository.save(chatuser);
    }

    @Override
    public void delete(ChatuserDto.UpdateReqDto param) {
        update(ChatuserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public ChatuserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        ChatuserDto.DetailResDto res = chatuserMapper.detail(param);
        return res;
    }

    @Override
    public ChatuserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<ChatuserDto.DetailResDto> list(ChatuserDto.ListReqDto param) {
        return addList(chatuserMapper.list(param));
    }

    public List<ChatuserDto.DetailResDto> addList(List<ChatuserDto.DetailResDto> list) {
        List<ChatuserDto.DetailResDto> returnList = new ArrayList<>();
        for(ChatuserDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(ChatuserDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(chatuserMapper.pagedListCount(param));
        res.setList(addList(chatuserMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<ChatuserDto.DetailResDto> scrollList(ChatuserDto.ScrollListReqDto param) {
        param.init();
        return addList(chatuserMapper.scrollList(param));
    }
}
