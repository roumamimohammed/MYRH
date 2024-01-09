package com.example.myrh_app.Mappers;

import com.example.myrh_app.DTO.PostulationDTO;
import com.example.myrh_app.DTO.SocieteDTO;
import com.example.myrh_app.Entities.PostulationEntite;
import com.example.myrh_app.Entities.SocieteEntite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostulationMapper {
    PostulationMapper INSTANCE = Mappers.getMapper(PostulationMapper.class);

    PostulationDTO toDto(PostulationEntite postulationEntite);

    PostulationEntite toEntity(PostulationDTO dto);
}
