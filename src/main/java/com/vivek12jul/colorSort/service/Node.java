package com.vivek12jul.colorSort.service;

import com.vivek12jul.colorSort.service.state.Action;
import com.vivek12jul.colorSort.service.state.State;

import java.util.ArrayList;
import java.util.Optional;

public class Node {
    private State state;
    private Node parent;
    private Action action;
    private int depth;

    public Node(State state, Node parent, Action action, int depth) {
        this.setState(state);
        this.setParent(parent);
        this.setAction(action);
        this.setDepth(depth);
    }

    public Node(Node node){
        this.setState(node.getState());
        this.setParent(node.getParent());
        this.setAction(node.getAction());
        this.setDepth(node.getDepth());
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = new State(state);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        if (action == null) {
            this.action = null;
        }else{
            this.action = new Action(action);
        }
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean isGoalNode(){
        return this.getState().isGoalState();
    }

    public ArrayList<Node> getAdjacentNodes() {
        ArrayList<Node> adjacentNodes = new ArrayList<>();
        ArrayList<Action> actions = this.getState().getPotentialActions();
        System.out.println(actions.size()+ " actions to take");

        for (Action action : actions) {
            Optional<State> state = this.getState().applyAction(action);
            state.ifPresent(value -> adjacentNodes.add(new Node(value, this, action, this.getDepth() + 1)));
        }
        return adjacentNodes;
    }
}
