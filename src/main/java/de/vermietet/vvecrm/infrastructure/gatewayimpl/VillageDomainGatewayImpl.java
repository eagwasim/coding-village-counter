package de.vermietet.vvecrm.infrastructure.gatewayimpl;

import de.vermietet.vvecrm.domain.VillageDomain;
import de.vermietet.vvecrm.domain.gateway.VillageDomainGateway;
import de.vermietet.vvecrm.infrastructure.exception.VillageAlreadyExistException;
import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.VillageJpaEntity;
import de.vermietet.vvecrm.infrastructure.persistence.repository.VillageJpaEntityRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class VillageDomainGatewayImpl implements VillageDomainGateway {
    private final VillageJpaEntityRepository villageJpaEntityRepository;

    @Inject
    public VillageDomainGatewayImpl(VillageJpaEntityRepository villageJpaEntityRepository) {
        this.villageJpaEntityRepository = villageJpaEntityRepository;
    }

    @Override
    public VillageDomain registerVillage(Long id, String name) {
        Optional<VillageJpaEntity> optionalVillageJpaEntity = villageJpaEntityRepository.findById(id);

        if (optionalVillageJpaEntity.isPresent()) {
            throw new VillageAlreadyExistException(id);
        }

        VillageJpaEntity villageJpaEntity = new VillageJpaEntity();
        villageJpaEntity.setId(id);
        villageJpaEntity.setName(name);

        villageJpaEntityRepository.save(villageJpaEntity);

        return new VillageDomain(id, name, villageJpaEntity.getDateCreated(), villageJpaEntity.getDateModified());
    }

    @Override
    public void deleteAllVillages(boolean hardDelete) {
        if (hardDelete) {
            villageJpaEntityRepository.deleteAll();
            villageJpaEntityRepository.flush();
        }

        // TODO Else set all status to DELETED
    }
}
