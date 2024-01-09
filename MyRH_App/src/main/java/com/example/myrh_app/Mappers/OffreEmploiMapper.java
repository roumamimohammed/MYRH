package com.example.myrh_app.Mappers;

import com.example.myrh_app.DTO.ChercheurEmploiDTO;
import com.example.myrh_app.DTO.OffreEmploiDTO;
import com.example.myrh_app.Entities.ChercheurEmploiEntite;
import com.example.myrh_app.Entities.OffreEmploiEntite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OffreEmploiMapper {
    OffreEmploiMapper INSTANCE = Mappers.getMapper(OffreEmploiMapper.class);

    OffreEmploiDTO toDtoint(Integer offreEmploiEntite);
    OffreEmploiDTO toDto(OffreEmploiEntite offreEmploiEntite);
    OffreEmploiEntite toEntity(OffreEmploiDTO dto);
}

