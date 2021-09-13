package main.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import main.dto.ApplianceDTO;
import main.service.ApplianceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "API для клиента")
@AllArgsConstructor
@RestController("/api/appliances")
public class AppliancesController {

    private ApplianceService service;

    @PostMapping("/")
    public void addAppliance(@RequestBody ApplianceDTO applianceDTO) {
        service.add(applianceDTO);
    }

    @GetMapping("/{id}")
    public ApplianceDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public void updateAppliance(@PathVariable UUID id, @RequestBody ApplianceDTO applianceDTO) {
        service.update(id, applianceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAppliance(@PathVariable UUID id) {
        service.delete(id);
    }
}
