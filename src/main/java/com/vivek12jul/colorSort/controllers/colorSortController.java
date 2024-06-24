package com.vivek12jul.colorSort.controllers;

import com.vivek12jul.colorSort.facade.ColorSortFacade;
import com.vivek12jul.colorSort.facade.Request;
import com.vivek12jul.colorSort.service.Solution;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class colorSortController {

//    private final ColorSortFacade colorSortFacade;
//    colorSortController(ColorSortFacade colorSortFacade) {
//        this.colorSortFacade = colorSortFacade;
//    }


    @PostMapping("/get-solution")
    public Solution getSolution(@Valid @RequestBody Request request) {
        System.out.println("controller");
        ColorSortFacade colorSortFacade = new ColorSortFacade();
        return colorSortFacade.solve(request);
    }
}
