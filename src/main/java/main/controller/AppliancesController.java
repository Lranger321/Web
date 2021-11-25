package main.controller;

import lombok.AllArgsConstructor;
import main.dto.ApplianceDTO;
import main.service.ApplianceService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class AppliancesController {

    private ApplianceService service;

    @GetMapping("/api/appliances/getAll")
    public List<ApplianceDTO> getAll() {
        return service.findAll();
    }

    @PostMapping("/api/appliances/")
    public ApplianceDTO addAppliance(@RequestBody ApplianceDTO applianceDTO) {
        return service.add(applianceDTO);
    }

    @GetMapping("/api/appliances/{id}")
    public ApplianceDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/api/appliances/{id}")
    public void updateAppliance(@PathVariable Long id, @RequestBody ApplianceDTO applianceDTO) {
        service.update(id, applianceDTO);
    }

    @DeleteMapping("/api/appliances/{id}")
    public void deleteAppliance(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/api/appliances/", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,
                        HttpMethod.POST,
                        HttpMethod.DELETE,
                        HttpMethod.PUT,
                        HttpMethod.OPTIONS)
                .build();
    }

    @RequestMapping(value = "/api/appliances/{id}", method = RequestMethod.OPTIONS)
    ResponseEntity<?> singularOptions(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET)
                .build();
    }
}
