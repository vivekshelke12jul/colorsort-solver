package com.vivek12jul.colorSort.facade;


import com.vivek12jul.colorSort.service.Solution;
import com.vivek12jul.colorSort.service.Solver;
import com.vivek12jul.colorSort.service.state.State;

import java.util.Optional;

public class ColorSortFacade {

    public Solution solve(Request request) {
        System.out.println("facade");
        State state = request.toState();
        Solver solver = new Solver(state);
        return solver.solve().get();
    }
}
