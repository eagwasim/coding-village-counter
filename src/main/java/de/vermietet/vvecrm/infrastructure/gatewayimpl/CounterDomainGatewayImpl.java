package de.vermietet.vvecrm.infrastructure.gatewayimpl;

import de.vermietet.vvecrm.domain.CounterDomain;
import de.vermietet.vvecrm.domain.VillageDomain;
import de.vermietet.vvecrm.domain.gateway.CounterDomainGateway;
import de.vermietet.vvecrm.infrastructure.exception.CounterAlreadyExistException;
import de.vermietet.vvecrm.infrastructure.exception.CounterNotFoundException;
import de.vermietet.vvecrm.infrastructure.exception.VillageNotFoundException;
import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.CounterJpaEntity;
import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.VillageCounterLogJpaEntity;
import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.VillageJpaEntity;
import de.vermietet.vvecrm.infrastructure.persistence.repository.CounterJpaEntityRepository;
import de.vermietet.vvecrm.infrastructure.persistence.repository.VillageCounterLogJpaEntityRepository;
import de.vermietet.vvecrm.infrastructure.persistence.repository.VillageJpaEntityRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Optional;

@Named
public class CounterDomainGatewayImpl implements CounterDomainGateway {
    private final CounterJpaEntityRepository counterJpaEntityRepository;
    private final VillageJpaEntityRepository villageJpaEntityRepository;
    private final VillageCounterLogJpaEntityRepository villageCounterLogJpaEntityRepository;

    @Inject
    public CounterDomainGatewayImpl(CounterJpaEntityRepository counterJpaEntityRepository, VillageJpaEntityRepository villageJpaEntityRepository, VillageCounterLogJpaEntityRepository villageCounterLogJpaEntityRepository) {
        this.counterJpaEntityRepository = counterJpaEntityRepository;
        this.villageJpaEntityRepository = villageJpaEntityRepository;
        this.villageCounterLogJpaEntityRepository = villageCounterLogJpaEntityRepository;
    }

    @Override
    public CounterDomain registerCounter(Long id, String address, Long villageId) {

        Optional<CounterJpaEntity> optionalCounterJpaEntity = counterJpaEntityRepository.findById(id);

        if (optionalCounterJpaEntity.isPresent()) {
            throw new CounterAlreadyExistException(id);
        }

        Optional<VillageJpaEntity> optionalVillageJpaEntity = villageJpaEntityRepository.findById(villageId);

        VillageJpaEntity villageJpaEntity = optionalVillageJpaEntity.orElseThrow(() -> new VillageNotFoundException(villageId));
        CounterJpaEntity counterJpaEntity = new CounterJpaEntity();

        counterJpaEntity.setAddress(address);
        counterJpaEntity.setId(id);
        counterJpaEntity.setVillage(villageJpaEntity);

        counterJpaEntityRepository.save(counterJpaEntity);

        CounterDomain counterDomain = new CounterDomain();
        counterDomain.setId(id);

        return counterDomain;
    }

    @Override
    public CounterDomain getCounterById(Long id) {
        Optional<CounterJpaEntity> optionalCounterJpaEntity = counterJpaEntityRepository.findById(id);

        CounterJpaEntity counterJpaEntity = optionalCounterJpaEntity.orElseThrow(() -> new CounterNotFoundException(id));
        VillageJpaEntity villageJpaEntity = counterJpaEntity.getVillage();

        return new CounterDomain(counterJpaEntity.getId(), counterJpaEntity.getAddress(), new VillageDomain(villageJpaEntity.getId(), villageJpaEntity.getName(), villageJpaEntity.getDateCreated(), villageJpaEntity.getDateModified()));
    }

    @Override
    public void deleteAll(boolean hardDelete) {
        if (hardDelete) {
            counterJpaEntityRepository.deleteAll();
            counterJpaEntityRepository.flush();
        }

        // TODO else set all status to DELETED

    }

    @Override
    public void logConsumption(Long counterId, BigDecimal amount) {
        Optional<CounterJpaEntity> optionalCounterJpaEntity = counterJpaEntityRepository.findById(counterId);

        CounterJpaEntity counterJpaEntity = optionalCounterJpaEntity.orElseThrow(() -> new CounterNotFoundException(counterId));

        VillageCounterLogJpaEntity villageCounterLogJpaEntity = new VillageCounterLogJpaEntity(counterJpaEntity.getVillage().getId(), counterJpaEntity.getId(), amount);

        villageCounterLogJpaEntityRepository.save(villageCounterLogJpaEntity);

    }
}
