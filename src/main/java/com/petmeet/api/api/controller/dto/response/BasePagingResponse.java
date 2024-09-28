package com.petmeet.api.api.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class BasePagingResponse<D> {

    private boolean isLast;
    private List<D> content;
    private int page;
    private int size;

    public static <D, T> BasePagingResponse<D> of(Page<T> page, List<D> content) {
        return BasePagingResponse.<D>builder()
                .isLast(page.isLast())
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .build();
    }
}
