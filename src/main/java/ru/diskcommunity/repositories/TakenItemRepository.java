package ru.diskcommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diskcommunity.domain.DisksEntity;
import ru.diskcommunity.domain.TakenItemEntity;
import ru.diskcommunity.domain.UsersEntity;

import java.util.List;

@Repository
public interface TakenItemRepository extends JpaRepository<TakenItemEntity, Integer> {
    List<DisksEntity> findAllByDisksNotContains();
    List<DisksEntity> findAllByUsers(UsersEntity usersEntity);
}
