package org.peoplist.repositories.base;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepository <T, Oid> extends JpaRepository<T, Oid> {


}
