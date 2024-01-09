package com.example.myrh_app.Mappers;

import com.example.myrh_app.DTO.SocieteDTO;
import com.example.myrh_app.Entities.SocieteEntite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocieteMapper {

    SocieteMapper INSTANCE = Mappers.getMapper(SocieteMapper.class);

    SocieteDTO toDto(SocieteEntite societeEntite);

    SocieteEntite toEntity(SocieteDTO dto);
}
