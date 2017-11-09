package ru.diskcommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diskcommunity.domain.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}
