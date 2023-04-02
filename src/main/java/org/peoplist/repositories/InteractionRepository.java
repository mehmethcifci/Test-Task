package org.peoplist.repositories;

import org.peoplist.entity.Interaction;
import org.peoplist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends BaseRepository<Interaction, Long> {


    List<Interaction> findByCandidateOid(Long oid);

}
