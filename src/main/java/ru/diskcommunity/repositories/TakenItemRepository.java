package ru.diskcommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diskcommunity.domain.TakenItemEntity;

@Repository
public interface TakenItemRepository extends JpaRepository<TakenItemEntity, Integer> {
}
