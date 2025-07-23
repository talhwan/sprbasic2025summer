package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Post;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostDto;
import com.thc.sprbasic2025summer.dto.PostimgDto;
import com.thc.sprbasic2025summer.mapper.PostMapper;
import com.thc.sprbasic2025summer.repository.PostRepository;
import com.thc.sprbasic2025summer.service.PostService;
import com.thc.sprbasic2025summer.service.PostimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    final PostRepository postRepository;
    final PostMapper postMapper;
    final PostimgService postimgService;

    /**/

    @Override
    public DefaultDto.CreateResDto create(PostDto.CreateReqDto param) {

        Post post = postRepository.save(param.toEntity());
        Long postId = post.getId();

        List<String> imgs = param.getImgs();
        if(imgs != null && !imgs.isEmpty()){
            for(String each : imgs){
                postimgService.create(PostimgDto.CreateReqDto.builder().postId(postId).img(each).build());
            }
        }
        return post.toCreateResDto();
    }

    @Override
    public void update(PostDto.UpdateReqDto param) {
        Post post = postRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ post.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ post.setTitle(param.getTitle()); }
        if(param.getContent() != null){ post.setContent(param.getContent()); }
        if(param.getImg() != null){ post.setImg(param.getImg()); }
        postRepository.save(post);
    }

    @Override
    public void delete(PostDto.UpdateReqDto param) {
        update(PostDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        PostDto.DetailResDto res = postMapper.detail(param);

        List<PostimgDto.DetailResDto> imgs =  postimgService.list(PostimgDto.ListReqDto.builder().deleted(false).postId(param.getId()).build());
        res.setImgs(imgs);

        return res;
    }

    @Override
    public PostDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<PostDto.DetailResDto> list(PostDto.ListReqDto param) {
        return addList(postMapper.list(param));
    }

    public List<PostDto.DetailResDto> addList(List<PostDto.DetailResDto> list) {
        List<PostDto.DetailResDto> returnList = new ArrayList<>();
        for(PostDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(PostDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postMapper.pagedListCount(param));
        res.setList(addList(postMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param) {
        param.init();
        return addList(postMapper.scrollList(param));
    }
}
