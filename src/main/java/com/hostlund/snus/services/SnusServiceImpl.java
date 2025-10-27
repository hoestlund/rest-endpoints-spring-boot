package com.hostlund.snus.services;

import com.hostlund.snus.controller.NotFoundException;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.repositories.SnusRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@AllArgsConstructor
public class SnusServiceImpl implements SnusService {

    private final SnusRepository snusRepository;

    @Override
    public void updateSnus(UUID id, Snus snus) {
        if (!snusRepository.existsById(id)) {
            throw new NotFoundException();
        }
        snus.setId(id);
        snusRepository.save(snus);
    }

    @Override
    public Snus saveSnus(Snus snus) {
        return snusRepository.save(snus);
    }

    @Override
    public List<Snus> listSnus() {
        return snusRepository.findAll();
    }

    @Override
    public void deleteSnusById(UUID id) {
        snusRepository.deleteById(id);
    }

    @Override
    public void patchSnus(UUID id, Snus snus) {
        Snus existingSnus = snusRepository.getReferenceById(id);

        if (snus.getName() != null) {
            existingSnus.setName(snus.getName());
        }
        if (snus.getDescription() != null) {
            existingSnus.setDescription(snus.getDescription());
        }
        if (snus.getFlavour() != null) {
            existingSnus.setFlavour(snus.getFlavour());
        }
        if (snus.getPrice() != null) {
            existingSnus.setPrice(snus.getPrice());
        }
        if (snus.getManufacturer() != null) {
            existingSnus.setManufacturer(snus.getManufacturer());
        }
        if (snus.getNicotineMilligramsPerGram() != null) {
            existingSnus.setNicotineMilligramsPerGram(snus.getNicotineMilligramsPerGram());
        }
        this.saveSnus(existingSnus);
    }

    @Override
    public Optional<Snus> getSnusById(UUID id) {
        return Optional.of(snusRepository.getReferenceById(id));
    }
}
