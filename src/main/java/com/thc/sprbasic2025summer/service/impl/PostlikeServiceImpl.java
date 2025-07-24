package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Post;
import com.thc.sprbasic2025summer.domain.Postlike;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostlikeDto;
import com.thc.sprbasic2025summer.mapper.PostlikeMapper;
import com.thc.sprbasic2025summer.repository.PostRepository;
import com.thc.sprbasic2025summer.repository.PostlikeRepository;
import com.thc.sprbasic2025summer.service.PostlikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostlikeServiceImpl implements PostlikeService {

    final PostlikeRepository postlikeRepository;
    final PostlikeMapper postlikeMapper;
    final PostRepository postRepository;

    @Override
    public PostlikeDto.WatchResDto watch(PostlikeDto.WatchReqDto param) {
        Postlike postlike = postlikeRepository.findByPostIdAndUserId(param.getPostId(), param.getUserId());
        boolean isLiked = postlike != null && !postlike.getDeleted();
        return PostlikeDto.WatchResDto.builder().isLiked(isLiked).build();
    }

    @Override
    public PostlikeDto.ToggleResDto toggle(PostlikeDto.ToggleReqDto param) {
        //일단 글이 있는지 부터 확인!!
        Long postId = param.getPostId();
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("no data"));

        Postlike postlike = postlikeRepository.findByPostIdAndUserId(param.getPostId(), param.getUserId());
        boolean like = param.getLike();
        if(postlike == null){
            if(like){
                create(PostlikeDto.CreateReqDto.builder().postId(param.getPostId()).userId(param.getUserId()).build());
            }
        } else {
            postlike.setDeleted(!like);
            postlikeRepository.save(postlike);
            postlike.toCreateResDto();
        }

        int count = postlikeMapper.pagedListCount(PostlikeDto.PagedListReqDto.builder().deleted(false).postId(postId).build());
        System.out.println("count : " + count);
        post.setCountlike(count);
        postRepository.save(post);

        return PostlikeDto.ToggleResDto.builder().countlike(count).build();
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(PostlikeDto.CreateReqDto param) {
        return postlikeRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(PostlikeDto.UpdateReqDto param) {
        Postlike postlike = postlikeRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ postlike.setDeleted(param.getDeleted()); }
        postlikeRepository.save(postlike);
    }

    @Override
    public void delete(PostlikeDto.UpdateReqDto param) {
        update(PostlikeDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostlikeDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        PostlikeDto.DetailResDto res = postlikeMapper.detail(param);
        return res;
    }

    @Override
    public PostlikeDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<PostlikeDto.DetailResDto> list(PostlikeDto.ListReqDto param) {
        return addList(postlikeMapper.list(param));
    }

    public List<PostlikeDto.DetailResDto> addList(List<PostlikeDto.DetailResDto> list) {
        List<PostlikeDto.DetailResDto> returnList = new ArrayList<>();
        for(PostlikeDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(PostlikeDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postlikeMapper.pagedListCount(param));
        res.setList(addList(postlikeMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostlikeDto.DetailResDto> scrollList(PostlikeDto.ScrollListReqDto param) {
        param.init();
        return addList(postlikeMapper.scrollList(param));
    }
}
