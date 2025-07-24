package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Chat;
import com.thc.sprbasic2025summer.dto.ChatuserDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatDto;
import com.thc.sprbasic2025summer.mapper.ChatMapper;
import com.thc.sprbasic2025summer.repository.ChatRepository;
import com.thc.sprbasic2025summer.service.ChatService;
import com.thc.sprbasic2025summer.service.ChatuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    final ChatRepository chatRepository;
    final ChatMapper chatMapper;
    final ChatuserService chatuserService;

    /**/

    @Override
    public DefaultDto.CreateResDto create(ChatDto.CreateReqDto param) {

        Long fromUserId = param.getFromUserId();
        Long toUserId = param.getToUserId();

        Long aId = fromUserId;
        Long bId = toUserId;
        if(fromUserId > toUserId){
            aId = toUserId;
            bId = fromUserId;
        }

        String title = aId + "_" + bId;
        Chat chat = chatRepository.findByTitle(title);
        if(chat == null){
            param.setTitle(title);
            chat = chatRepository.save(param.toEntity());
        }
        Long chatId = chat.getId();

        chatuserService.create(ChatuserDto.CreateReqDto.builder().chatId(chatId).userId(toUserId).build());
        chatuserService.create(ChatuserDto.CreateReqDto.builder().chatId(chatId).userId(fromUserId).build());

        return chat.toCreateResDto();
    }

    @Override
    public void update(ChatDto.UpdateReqDto param) {
        Chat chat = chatRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ chat.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ chat.setTitle(param.getTitle()); }
        chatRepository.save(chat);
    }

    @Override
    public void delete(ChatDto.UpdateReqDto param) {
        update(ChatDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public ChatDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        ChatDto.DetailResDto res = chatMapper.detail(param);
        return res;
    }

    @Override
    public ChatDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<ChatDto.DetailResDto> list(ChatDto.ListReqDto param) {
        return addList(chatMapper.list(param));
    }

    public List<ChatDto.DetailResDto> addList(List<ChatDto.DetailResDto> list) {
        List<ChatDto.DetailResDto> returnList = new ArrayList<>();
        for(ChatDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(ChatDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(chatMapper.pagedListCount(param));
        res.setList(addList(chatMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<ChatDto.DetailResDto> scrollList(ChatDto.ScrollListReqDto param) {
        param.init();
        return addList(chatMapper.scrollList(param));
    }
}
