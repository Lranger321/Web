package main.service.mapper;

import main.dao.entity.Appliance;
import main.dto.ApplianceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ApplianceMapper {

    Appliance fromDTO(ApplianceDTO applianceDTO);

    ApplianceDTO fromEntity(Appliance appliance);
}
