package com.codegym.cms.service;

import com.codegym.cms.model.Team;

public interface TeamService {
    Iterable<Team> findAll();

    Team findById(long id);

    void save(Team team);

    void remove(long id);

}
