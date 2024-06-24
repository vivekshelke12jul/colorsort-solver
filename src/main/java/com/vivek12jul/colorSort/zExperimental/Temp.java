package com.vivek12jul.colorSort.zExperimental;

import com.vivek12jul.colorSort.service.Node;
import com.vivek12jul.colorSort.service.Solution;
import com.vivek12jul.colorSort.service.state.Bottle;
import com.vivek12jul.colorSort.service.state.State;

import java.util.ArrayList;
import java.util.Optional;

public class Temp {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        Bottle bottle = new Bottle(colors);

        ArrayList<Bottle> bottleList = new ArrayList<>();
        bottleList.add(bottle);

//        Optional<Solution> solution = Optional.empty().get();


//        if(solution.isPresent())
//
//        State state = new State(bottleList, 3, 1);
//        State nstate = null;
//
//        Node node = new Node(state, null, null, 0);
//        System.out.println(node.toString());
//
//        node = new Node(nstate,null, null, 0);
//        System.out.println(node.toString());
    }
}
