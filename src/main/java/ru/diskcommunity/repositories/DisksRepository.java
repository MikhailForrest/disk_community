package ru.diskcommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diskcommunity.domain.DisksEntity;

import java.util.List;

@Repository
public interface DisksRepository extends JpaRepository<DisksEntity, Integer> {
    List<DisksEntity> findAllByIdOwner(Integer idOwner);
    List<DisksEntity> findAllByUsersByIdOwnerNull();
    List<DisksEntity> findAllByUsersByIdOwner(Integer usersByIdOwner);
    List<DisksEntity> findAllByIdOwnerAndUsersByIdOwnerNotNull(Integer idOwner);
}
