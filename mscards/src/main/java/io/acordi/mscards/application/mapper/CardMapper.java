package io.acordi.mscards.application.mapper;

import io.acordi.mscards.application.dto.CardRequestDTO;
import io.acordi.mscards.domain.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    @Mapping(target = "id", ignore = true)
    Card toCard(CardRequestDTO request);

}
