package main.service.mapper;

import main.dao.entity.Appliance;
import main.dto.ApplianceDTO;

public interface ApplianceMapper {

    Appliance fromDTO(ApplianceDTO applianceDTO);

    ApplianceDTO fromEntity(Appliance appliance);
}
