package online.adambem.simplecrudcrm.controller;

import online.adambem.simplecrudcrm.entity.Customer;
import online.adambem.simplecrudcrm.service.CustomerServiceImpl;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl service;

    @Autowired
    public CustomerController(CustomerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("customers", service.findAll());
        return "list-customers";
    }

    @GetMapping("/addCustomerForm")
    public String showAddCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/editCustomerForm")
    public String showCustomerForm(Model model, @RequestParam("id") int id) {

        Customer customer = service.findById(id);
        model.addAttribute("customer", customer);

        return "customer-form";
    }



    @GetMapping("/deleteCustomerConfirmation")
    public String showDeleteCustomerForm(Model model, @RequestParam int id) {
        Customer customer = service.findById(id);
        model.addAttribute("customer", customer);

        return "confirm-delete";
    }

    @PostMapping("/save")
    public String saveCustomer(Model model,
                               @ModelAttribute("customer") Customer customer) {
        service.save(customer);

        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(Model model,
                                 @ModelAttribute("id") int id) {
        Customer customer = service.findById(id);
        service.delete(customer);

        return "redirect:/customers/list";
    }


}
