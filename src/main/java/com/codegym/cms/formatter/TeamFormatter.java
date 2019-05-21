package com.codegym.cms.formatter;

import com.codegym.cms.model.Team;
import com.codegym.cms.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

@Component

public class TeamFormatter implements Formatter<Team>{
    private TeamService teamService;

    @Autowired
    public TeamFormatter(TeamService teamService){
        this.teamService = teamService;
    }

    @Override
    public Team parse(String text, Locale locale) throws ParseException {
        return teamService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Team object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}
