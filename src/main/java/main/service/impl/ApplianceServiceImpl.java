package main.service.impl;

import lombok.AllArgsConstructor;
import main.dao.entity.Appliance;
import main.dao.repository.ApplianceRepository;
import main.dto.ApplianceDTO;
import main.exception.ApplianceNotFoundException;
import main.service.ApplianceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplianceServiceImpl implements ApplianceService {

    private ApplianceRepository repository;

    public ApplianceDTO add(ApplianceDTO applianceDTO) {
        return fromEntity(repository.save(fromDTO(applianceDTO)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, ApplianceDTO dto) {
        Appliance appliance = repository.findById(id)
                .orElseThrow(() -> new ApplianceNotFoundException(String.format("Appliance with id [%d] not found", id)));
        Appliance newAppliance = fromDTO(dto);
        newAppliance.setId(appliance.getId());
    }

    public ApplianceDTO getById(Long id) {
        return fromEntity(repository.findById(id)
                .orElseThrow(() -> new ApplianceNotFoundException(String.format("Appliance with id [%s] not found", id.toString()))));
    }

    @Override
    public List<ApplianceDTO> findAll() {
        return repository.findAll().stream().map(this::fromEntity).collect(Collectors.toList());
    }

    private Appliance fromDTO(ApplianceDTO dto) {
        return Appliance.builder()
                .type(dto.getType())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .price(dto.getPrice())
                .build();
    }

    private ApplianceDTO fromEntity(Appliance appliance) {
        return ApplianceDTO.builder()
                .id(appliance.getId())
                .brand(appliance.getBrand())
                .model(appliance.getModel())
                .price(appliance.getPrice())
                .type(appliance.getType())
                .build();
    }
}
