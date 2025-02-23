package ma.ensa.apms.controller;


import ma.ensa.apms.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
}
