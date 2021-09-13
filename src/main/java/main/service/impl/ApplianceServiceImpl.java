package main.service.impl;

import lombok.AllArgsConstructor;
import main.dao.entity.Appliance;
import main.dao.repository.ApplianceRepository;
import main.dto.ApplianceDTO;
import main.exception.ApplianceNotFoundException;
import main.service.ApplianceService;
import main.service.mapper.ApplianceMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplianceServiceImpl implements ApplianceService {

    private ApplianceRepository repository;
    private ApplianceMapper mapper;

    public void add(ApplianceDTO applianceDTO) {
        repository.save(mapper.fromDTO(applianceDTO));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void update(UUID id, ApplianceDTO dto) {
        Appliance appliance = repository.findById(id)
                .orElseThrow(() -> new ApplianceNotFoundException(String.format("Appliance with id [%s] not found"), id.toString()));
        Appliance newAppliance = mapper.fromDTO(dto);
        newAppliance.setId(appliance.getId());
    }

    public ApplianceDTO getById(UUID id) {
        return mapper.fromEntity(repository.findById(id)
                .orElseThrow(() -> new ApplianceNotFoundException(String.format("Appliance with id [%s] not found"), id.toString())));
    }
}
