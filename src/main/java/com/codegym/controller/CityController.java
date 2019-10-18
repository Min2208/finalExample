package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("country")
    public Iterable<Country> allCountry() {
        return countryService.findAll();


    }

    @GetMapping
    public ModelAndView home(@RequestParam("s") Optional<String> s,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size, Pageable pageable) {
        pageable = new PageRequest(page, size);
        ModelAndView modelAndView = new ModelAndView("home");
        Page<City> cities;
        if (s.isPresent()) {
            cities = cityService.search(s.get(), pageable);
            modelAndView.addObject("search", s.get());
        } else {
            cities = cityService.findAll(pageable);
            modelAndView.addObject("search", "");
        }

        modelAndView.addObject("cities", cities);


        return modelAndView;
    }

    @GetMapping("info/{id}")
    public ModelAndView info(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("city", cityService.findOne(id));
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", cityService.findOne(id));
        return modelAndView;
    }

    @PostMapping("edit")
    public String editCity(@Validated City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }
        cityService.save(city);

        return "redirect:/";
    }

    @GetMapping("deleteCity/{id}")
    public ModelAndView deleteForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city", cityService.findOne(id));
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        cityService.delete(id);
        return "redirect:/";
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create", "city", new City());
        return modelAndView;
    }

    @PostMapping("create")
    public String creat(@Validated City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        cityService.save(city);
        return "redirect:/";
    }


}
