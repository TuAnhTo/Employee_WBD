package com.codegym.cms.repository;


import com.codegym.cms.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepository extends PagingAndSortingRepository<Team,Long> {
}
