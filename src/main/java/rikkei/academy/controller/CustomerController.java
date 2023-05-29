package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Country;
import rikkei.academy.model.Customer;
import rikkei.academy.service.country.ICountryService;
import rikkei.academy.service.customer.ICustomerService;

import java.util.Optional;


@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICountryService countryService;
    @ModelAttribute("countries")
    Iterable<Country> getlist(){
        return countryService.findAll();
    };
    @GetMapping("/")
    public String home(@RequestParam("sortBy") Optional<String> sortBy, ModelMap model, Pageable pageable) {
        Sort sort = null;
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "Age-ASC":
                    sort = Sort.by("age").ascending();
                    break;
                case "Age-DESC":
                    sort = Sort.by("age").descending();
                    break;
                case "Name-ASC":
                    sort = Sort.by("name").ascending();
                    break;
                case "Name-DESC":
                    sort = Sort.by("name").descending();
                    break;
                default:
                    break;
            }

        }else {
            sort = Sort.by("name").ascending().and(Sort.by("age").ascending());
        }
        Page<Customer> list = customerService.findAll(pageable,sort);
        model.addAttribute("list", list);

        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        customerService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView add() {
        return new ModelAndView("add", "customer", new Customer());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer c) {
        customerService.save(c);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        return new ModelAndView("edit", "customer", customer.get());
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer c) {
        customerService.save(c);
        return "redirect:/";
    }

}
