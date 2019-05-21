package com.codegym.cms.controller;

import com.codegym.cms.model.Employee;
import com.codegym.cms.model.Team;
import com.codegym.cms.service.EmployeeService;
import com.codegym.cms.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/teams")
    public ModelAndView listTeam(){
        Iterable<Team> teams = teamService.findAll();
        ModelAndView modelAndView = new ModelAndView("/team/list");
        modelAndView.addObject("team", teams);
        return modelAndView;
    }

    @GetMapping("/create-team")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    @PostMapping("/create-team")
    public ModelAndView saveTeam(@ModelAttribute("team") Team team){
        teamService.save(team);

        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        modelAndView.addObject("message", "New team created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-team/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Team team = teamService.findById(id);
        if(team != null) {
            ModelAndView modelAndView = new ModelAndView("/team/edit");
            modelAndView.addObject("team", team);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-team")
    public ModelAndView updateTeam(@ModelAttribute("team") Team team){
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "team updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-team/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Team team = teamService.findById(id);
        if(team != null) {
            ModelAndView modelAndView = new ModelAndView("/team/delete");
            modelAndView.addObject("team", team);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-team")
    public String deleteTeam(@ModelAttribute("team") Team team){
        teamService.remove(team.getId());
        return "redirect:teams";
    }

    @GetMapping("/view-team/{id}")
    public ModelAndView viewTeam(@PathVariable("id") Long id){
        Team team = teamService.findById(id);
        if(team == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Employee> employees = employeeService.findAllByTeam(team);
        ModelAndView modelAndView = new ModelAndView("/team/view");
        modelAndView.addObject("team", team);
        modelAndView.addObject("employee", employees);
        return modelAndView;
    }

}
