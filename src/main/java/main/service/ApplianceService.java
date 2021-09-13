package main.service;

import main.dto.ApplianceDTO;

import java.util.UUID;

public interface ApplianceService {

    void add(ApplianceDTO applianceDTO);

    void delete(UUID id);

    void update(UUID id, ApplianceDTO dto);

    ApplianceDTO getById(UUID id);
}
