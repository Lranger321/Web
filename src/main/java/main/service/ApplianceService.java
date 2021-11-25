package main.service;

import main.dto.ApplianceDTO;

import java.util.List;
import java.util.UUID;

public interface ApplianceService {

    ApplianceDTO add(ApplianceDTO applianceDTO);

    void delete(Long id);

    void update(Long id, ApplianceDTO dto);

    ApplianceDTO getById(Long id);

    List<ApplianceDTO> findAll();
}
