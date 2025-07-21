package com.thc.sprbasic2025summer.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class DefaultDto {
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id; //필수!!
        Boolean deleted;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id; //필수!!
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto {
        Boolean deleted;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto {
        Integer callpage; //내가 호출하는 페이지가 몇번째 페이지 인지
        Integer offset; // 몇번째 순번 글부터 보여줄지
        Integer perpage; //한번에 몇개씩 볼지
        String orderby; //정렬 기준
        String orderway; //정렬 방향!

        Boolean deleted;
        public PagedListResDto init(int totalCount){
            //한번에 볼 페이지수 부터 정리!
            int perpage = 10;
            if(getPerpage() != null){
                perpage = getPerpage();
            }
            if(perpage < 2){
                perpage = 2;
            }
            setPerpage(perpage);

            // 전체 글 갯수를 활용해서 전체 페이지수 정리!
            int totalPage = totalCount / perpage;
            if(totalCount % perpage > 0){
                totalPage++;
            }

            // 내 요청 페이지가 정상적인지 검토!
            int callpage = 1;
            if(getCallpage() != null){
                callpage = getCallpage();
            }
            if(callpage > totalPage){
                callpage = totalPage;
            }
            if(callpage < 1){
                callpage = 1;
            }
            setCallpage(callpage);

            // 순번 계산!
            int offset = (callpage - 1) *  perpage;
            setOffset(offset);

            //정렬 초기값 설정
            String orderby = "id";
            if(getOrderby() != null && !getOrderby().isEmpty()){
                orderby = getOrderby();
            }
            setOrderby(orderby);
            String orderway = "desc";
            if(getOrderway() != null && !getOrderway().isEmpty()){
                orderway = getOrderway();
            }
            setOrderway(orderway);

            return PagedListResDto.builder().callpage(callpage)
                    .perpage(perpage)
                    .totalpage(totalPage)
                    .totalcount(totalCount)
                    .build();
        }
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListResDto {
        Integer callpage; // 실제로 호출하는 페이지가 몇번째 페이지 인지
        Integer perpage; //한번에 몇개씩 볼지
        Integer totalpage; // 전체 페이지수
        Integer totalcount; // 전체 글 갯수

        Object list;
    }


    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto {
        Long cursor; // 불러올 자료의 기준!
        Integer perpage; //한번에 몇개씩 볼지
        String orderway; //정렬 방향!

        Boolean deleted;

        public void init(){
            //한번에 볼 페이지수 부터 정리!
            int perpage = 10;
            if(getPerpage() != null){
                perpage = getPerpage();
            }
            if(perpage < 2){
                perpage = 2;
            }
            setPerpage(perpage);

            String orderway = "desc";
            if(getOrderway() != null && !getOrderway().isEmpty()){
                orderway = getOrderway();
            }
            setOrderway(orderway);
        }
    }
}
