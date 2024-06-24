package com.vivek12jul.colorSort.service;

import com.vivek12jul.colorSort.service.state.Action;
import com.vivek12jul.colorSort.service.state.State;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private boolean isSolvable;
    private final ArrayDeque<State> solutionStates;
    private final ArrayDeque<Action> solutionActions;

    public Solution() {
        this.setIsSolvable(false);
        this.solutionStates = new ArrayDeque<>();
        this.solutionActions = new ArrayDeque<>();
    }

    public boolean getIsSolvable() {
        return isSolvable;
    }

    public void setIsSolvable(boolean solvable) {
        isSolvable = solvable;
    }

    public ArrayDeque<State> getSolutionStates() {
        return solutionStates;
    }

    public ArrayDeque<Action> getSolutionActions() {
        return solutionActions;
    }

    public void prependSolutionState(State state) {
        this.solutionStates.addFirst(state);
    }
    public void prependSolutionAction(Action action) {
        this.solutionActions.addFirst(action);
    }
}
