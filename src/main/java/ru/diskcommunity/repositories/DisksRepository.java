package ru.diskcommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diskcommunity.domain.DisksEntity;

@Repository
public interface DisksRepository extends JpaRepository<DisksEntity, Integer> {
}
