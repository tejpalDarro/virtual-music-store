package com.jwt.spring_security_html.dto;

import java.util.List;

public record AlbumPageResponse(List<AlbumDto> albumDto,
                                Integer pageNumber,
                                Integer pageSize,
                                Integer totalElement,
                                int totalPage,
                                boolean isLast) {

}