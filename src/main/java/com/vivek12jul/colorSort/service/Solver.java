package com.vivek12jul.colorSort.service;

import com.vivek12jul.colorSort.facade.Request;
import com.vivek12jul.colorSort.service.state.Action;
import com.vivek12jul.colorSort.service.state.State;
import org.springframework.stereotype.Service;

import java.util.*;

public class Solver {

    private Node startNode;
    private final ArrayDeque<Node> nodeQueue = new ArrayDeque<>();
    private final Set<State> visitedStates = new HashSet<>();
    private Integer totalVisitedStates;
    Solution solution;



    public Solver(State initialState){
        this.setStartNode(new Node(initialState, null, null, 0));
        this.nodeQueue.push(getStartNode());
        this.visitedStates.add(initialState);
        this.totalVisitedStates = 1;
        this.solution = new Solution();
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = new Node(startNode);
    }

    public Optional<Solution> solve(){
        System.out.println("solver");
        while(!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.removeFirst();
            currentNode.getState().printState();

            if(currentNode.isGoalNode()){
                System.out.println("Solution found!");

                //backtracking
                while(currentNode.getParent() != null){
                    solution.prependSolutionState(currentNode.getState());
                    solution.prependSolutionAction(currentNode.getAction());
                    currentNode = currentNode.getParent();
                }

                return Optional.of(solution);
            }

            ArrayList<Node> adjacentNodes = currentNode.getAdjacentNodes();
            System.out.println(adjacentNodes.size() + " nodes to visit");
            for (Node node : adjacentNodes) {
                if(!visitedStates.contains(node.getState())){
                    nodeQueue.push(node);
                    visitedStates.add(node.getState());
                    totalVisitedStates++;
                }
            }

        }
        return Optional.of(solution);
    }

}
