package de.vermietet.vvecrm.infrastructure.persistence.queryset;

public final class VillageCounterLogJpaEntityQuerySet {
    public static final String VILLAGE_CONSUMPTION_QUERY = "select " +
            "new de.vermietet.vvecrm.infrastructure.persistence.model.VillageConsumptionStatistic(v.name, sum(c.amount)) " +
            "from VillageCounterLogJpaEntity c left join VillageJpaEntity v on v.id = c.villageId where c.dateCreated >= ?1 and c.dateCreated <= ?2 " +
            "group by v.name order by v.name";
}
