package com.hostlund.snus.services;

import com.hostlund.snus.controller.NotFoundException;
import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.mappers.SnusMapper;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.repositories.SnusRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SnusServiceImpl implements SnusService {

    private final SnusRepository snusRepository;
    private final SnusMapper snusMapper;


    @Override
    public void updateSnus(UUID id, SnusDTO snus) {
        if (!snusRepository.existsById(id)) {
            throw new NotFoundException();
        }
        snusRepository.save(snusMapper.DTOToSnus(snus));
    }

    @Override
    public SnusDTO saveSnus(SnusDTO snus) {
        snusRepository.save(snusMapper.DTOToSnus(snus));
        return snus;
    }

    @Override
    public List<SnusDTO> listSnus() {
        return snusRepository.findAll().stream().map(snusMapper::snusToDTO).toList();
    }

    @Override
    public void deleteSnusById(UUID id) {
        snusRepository.deleteById(id);
    }

    @Override
    public void patchSnus(UUID id, SnusDTO snus) {
        Snus existingSnus = snusRepository.getReferenceById(id);

        if (snus.name() != null) {
            existingSnus.setName(snus.name());
        }
        if (snus.description() != null) {
            existingSnus.setDescription(snus.description());
        }
        if (snus.flavour() != null) {
            existingSnus.setFlavour(snus.flavour());
        }
        if (snus.price() != null) {
            existingSnus.setPrice(snus.price());
        }
        if (snus.manufacturer() != null) {
            existingSnus.setManufacturer(snus.manufacturer());
        }
        if (snus.nicotineMilligramsPerGram() != null) {
            existingSnus.setNicotineMilligramsPerGram(snus.nicotineMilligramsPerGram());
        }
        snusRepository.save(existingSnus);
    }

    @Override
    public Optional<SnusDTO> getSnusById(UUID id) {
        return Optional.ofNullable(snusMapper.snusToDTO(snusRepository.findById(id).orElse(null)));
    }
}
