package online.adambem.simplecrudcrm.controller;

import online.adambem.simplecrudcrm.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", service.findAll());
        return "list-employees";
    }

}
