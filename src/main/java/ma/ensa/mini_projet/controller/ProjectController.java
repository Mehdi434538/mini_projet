package ma.ensa.mini_projet.controller;


import ma.ensa.mini_projet.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
}
