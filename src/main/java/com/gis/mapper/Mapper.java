package com.gis.mapper;

import com.gis.dto.PostDto;
import com.gis.entity.PostEntity;

@org.mapstruct.Mapper
public interface Mapper {

	PostDto maptoPostDto(PostEntity PostEntity);

	PostEntity mapToPostEntity(PostDto postDto);

}
