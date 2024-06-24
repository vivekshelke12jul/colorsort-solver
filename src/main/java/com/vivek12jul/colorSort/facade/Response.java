//package com.vivek12jul.colorSort.facade;
//
//import com.vivek12jul.colorSort.service.Node;
//import com.vivek12jul.colorSort.service.Solution;
//import com.vivek12jul.colorSort.service.state.Action;
//import com.vivek12jul.colorSort.service.state.Bottle;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Optional;
//
//public class Response {
//
//    private Boolean isSolvable;
//    private int totalVisitedStates;
//    private final ArrayDeque<ArrayList<ArrayList<String>>> solutionMatrixList;
//    private final ArrayDeque<Action> solutionActionList;
//
//    public Response() {
//
//    }
//
//    public Response(Optional<Solution> solution) {
//
//        if(solution.isPresent()) {
//            this.isSolvable = true;
//            this.totalVisitedStates = solution.get().getTotalVisitedStates();
//            this.solutionMatrixList = solution.get().getSolutionStates();
//            this.solutionActionList = solution.get().getSolutionActions();
//        }

//        this.isSolvable = true;
//        this.totalVisitedStates = totalVisitedStates;
//        solutionMatrixList = new ArrayDeque<ArrayList<ArrayList<String>>>();
//        solutionActionList = new ArrayDeque<Action>();
//    }
//    public Response() {
//        solutionMatrixList = new ArrayDeque<ArrayList<ArrayList<String>>>();
//        solutionActionList = new ArrayDeque<Action>();
//    }

//    public Boolean getIsSolvable() {
//        return isSolvable;
//    }
//
//    public void setIsSolvable(Boolean solvable) {
//        isSolvable = solvable;
//    }
//
//    public int getTotalVisitedStates() {
//        return totalVisitedStates;
//    }
//
//    public void setTotalVisitedStates(int totalVisitedStates) {
//        this.totalVisitedStates = totalVisitedStates;
//    }
//
//    public ArrayDeque<ArrayList<ArrayList<String>>> getSolutionMatrixList() {
//        return solutionMatrixList;
//    }
//
//    public ArrayDeque<Action> getSolutionActionList() {
//        return solutionActionList;
//    }
//
//    public void prependToSolutionPath(Node node){
//        ArrayList<Bottle> bottleList = node.getState().getBottleList();
//        Action action = node.getAction();
//
//        ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
//        for(Bottle bottle : bottleList){
//            matrix.add(bottle.toList());
//        }
//
//        solutionMatrixList.addFirst(matrix);
//        solutionActionList.addFirst(action);
//    }

//}
