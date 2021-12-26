import main.dao.entity.Appliance;
import main.dao.repository.ApplianceRepository;
import main.dto.ApplianceDTO;
import main.exception.ApplianceNotFoundException;
import main.service.ApplianceService;
import main.service.impl.ApplianceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ApplianceServiceImplTest {

    private static final Appliance APPLIANCE = Appliance.builder()
            .id(1L)
            .price(BigDecimal.ONE)
            .model("model")
            .brand("brand")
            .type("type")
            .build();
    private static final ApplianceDTO APPLIANCE_DTO = ApplianceDTO.builder()
            .price(BigDecimal.ONE)
            .model("model")
            .brand("brand")
            .type("type")
            .id(1L)
            .build();
    private ApplianceService applianceService;
    private ApplianceRepository repository = Mockito.mock(ApplianceRepository.class);

    @BeforeEach
    void setUp() {
        applianceService = new ApplianceServiceImpl(repository);
    }

    @Test
    public void getSuccess() {
        when(repository.findById(1L)).thenReturn(Optional.of(APPLIANCE));
        ApplianceDTO applianceDTO = applianceService.getById(1L);
        verify(repository).findById(1L);
        assertEquals(APPLIANCE.getBrand(), applianceDTO.getBrand());
        assertEquals(APPLIANCE.getType(), applianceDTO.getType());
        assertEquals(APPLIANCE.getModel(), applianceDTO.getModel());
        assertEquals(APPLIANCE.getPrice(), applianceDTO.getPrice());
    }

    @Test
    public void getError() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ApplianceNotFoundException.class, () -> applianceService.getById(1L));
    }

    @Test
    public void addSuccess() {
        when(repository.save(any())).thenReturn(APPLIANCE);
        ApplianceDTO applianceDTO = applianceService.add(APPLIANCE_DTO);
        verify(repository).save(any());
        assertEquals(APPLIANCE_DTO, applianceDTO);
    }

    @Test
    public void deleteSuccess() {
        applianceService.delete(1L);
        verify(repository).deleteById(1L);
    }
}