package ru.diskcommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.diskcommunity.domain.DisksEntity;
import ru.diskcommunity.domain.UsersEntity;
import ru.diskcommunity.repositories.DisksRepository;
import ru.diskcommunity.repositories.TakenItemRepository;
import ru.diskcommunity.repositories.UsersRepository;

import java.util.List;

@Component("disksService")
public class DisksServiceImpl implements DisksService {

    private final DisksRepository disksRepository;
    private final UsersRepository usersRepository;
    private final TakenItemRepository takenItemRepository;

    @Autowired
    public DisksServiceImpl(DisksRepository disksRepository,
                            UsersRepository usersRepository,
                            TakenItemRepository takenItemRepository) {
        this.disksRepository = disksRepository;
        this.usersRepository = usersRepository;
        this.takenItemRepository = takenItemRepository;
    }

    public List<DisksEntity> OwnDisksForUser(int userId) {
        return disksRepository.findAllByIdOwner(userId);

    }

    public List<DisksEntity> AllFreeDisks() {

        return disksRepository.findAllByHolderNull();
    }

    public List<DisksEntity> DisksTakenByUser(int userId) {
        return disksRepository.findAllByHolder(userId);
    }

    public List<DisksEntity> DisksTakenFromUser(int userId) {
        return disksRepository.findAllByIdOwnerAndHolderNotNull(userId);
    }
}
