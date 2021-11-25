package main.dao.repository;

import main.dao.entity.Appliance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplianceRepository extends CrudRepository<Appliance, Long> {

    List<Appliance> findAll();
}
