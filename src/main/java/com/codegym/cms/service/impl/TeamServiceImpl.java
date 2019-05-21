package com.codegym.cms.service.impl;

import com.codegym.cms.model.Team;
import com.codegym.cms.repository.TeamRepository;
import com.codegym.cms.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void remove(long id) {
        teamRepository.delete(id);

    }
}
