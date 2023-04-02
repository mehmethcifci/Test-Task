package org.peoplist.repositories;

import org.peoplist.entity.Candidate;
import org.peoplist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends BaseRepository<Candidate, Long> {
}
