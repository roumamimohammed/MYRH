package com.example.myrh_app.Mappers;

import com.example.myrh_app.DTO.AgentDTO;
import com.example.myrh_app.Entities.AgentEntite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgentMapper {
    AgentMapper INSTANCE = Mappers.getMapper(AgentMapper.class);

    AgentDTO toDto(AgentEntite agentEntite);

    AgentEntite toEntity(AgentDTO dto);
}
