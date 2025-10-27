package com.hostlund.snus.mappers;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import org.mapstruct.Mapper;

@Mapper
public interface SnusMapper {

    SnusDTO snusToDTO(Snus snus);

    Snus DTOToSnus(SnusDTO snusDTO);

}
