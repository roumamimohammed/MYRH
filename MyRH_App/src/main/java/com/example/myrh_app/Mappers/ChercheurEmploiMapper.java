package com.example.myrh_app.Mappers;

import com.example.myrh_app.DTO.ChercheurEmploiDTO;
import com.example.myrh_app.DTO.SocieteDTO;
import com.example.myrh_app.Entities.ChercheurEmploiEntite;
import com.example.myrh_app.Entities.SocieteEntite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChercheurEmploiMapper {
    ChercheurEmploiMapper INSTANCE = Mappers.getMapper(ChercheurEmploiMapper.class);

    ChercheurEmploiDTO toDto(ChercheurEmploiEntite chercheurEmploiEntite);

    ChercheurEmploiEntite toEntity(ChercheurEmploiDTO dto);
}
