package ru.diskcommunity.service;

import ru.diskcommunity.domain.DisksEntity;

import java.util.List;

public interface DisksService {
    List<DisksEntity> OwnDisksForUser(int userId);

    List<DisksEntity> AllFreeDisks();

    List<DisksEntity> DisksTakenByUser(int userId);

    List<DisksEntity> DisksTakenFromUser(int userId);
}
