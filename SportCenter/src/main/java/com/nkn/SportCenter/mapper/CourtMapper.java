package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nkn.SportCenter.dto.request.CourtRequest;
import com.nkn.SportCenter.entities.Court;

@Mapper(componentModel = "spring")
public interface CourtMapper {
    @Mapping(target = "category", ignore= true)
    Court toCourt(CourtRequest request);
}
 