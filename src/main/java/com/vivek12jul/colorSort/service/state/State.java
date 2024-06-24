package com.vivek12jul.colorSort.service.state;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class State {
    private static Integer BOTTLE_COUNT;
    private static Integer BOTTLE_CAPACITY;
    private ArrayList<Bottle> bottleList;

    public State(ArrayList<Bottle> bottleList) {
        this.setBottleList(bottleList);
    }
    public State(State state){
        this.setBottleList(state.getBottleList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(bottleList, state.bottleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottleList);
    }

    public static void setBottleCount(int bottleCount){
        State.BOTTLE_COUNT = bottleCount;
    }

    public static void setBottleCapacity(int bottleCapacity){
        State.BOTTLE_CAPACITY = bottleCapacity;
        Bottle.setBottleCapacity(bottleCapacity);
    }

    public Bottle getBottle(int i) {
        if(i<0 || i>=BOTTLE_COUNT) throw new RuntimeException("Index out of bounds: trying to acces bottle at index "+i);
        return bottleList.get(i);
    }
    public ArrayList<Bottle> getBottleList() {
        return bottleList;
    }

    public void setBottleList(ArrayList<Bottle> bottleList) {
        this.bottleList = new ArrayList<>();
        for(Bottle bottle : bottleList){
            this.bottleList.add(new Bottle(bottle));
        }
    }
    @JsonIgnore
    public boolean isGoalState(){
        return bottleList.stream()
                .allMatch(bottle -> bottle.isEmpty() || (bottle.isFull() && bottle.isSameColor()));
    }


    @JsonIgnore
    public ArrayList<Action> getPotentialActions() {
        //this approach is O(n^2)
        //you can optimize it to O(1) by using a hashset

        ArrayList<Action> potentialActions = new ArrayList<>();

        for(int i = 0; i< BOTTLE_COUNT; i++){
            Bottle pickBottle = bottleList.get(i);
            if(pickBottle.isEmpty()) continue;
            String picColor = pickBottle.getTopColor();

            for(int j = 0; j< BOTTLE_COUNT; j++){
                System.out.print("\n"+picColor+i+"->"+j);
                if(i==j) continue;
                Bottle putbottle = bottleList.get(j);

                // Empty putBottle
                if(putbottle.isEmpty()){
                    System.out.println("->empty");
                    potentialActions.add(new Action(i, j));
                }
                // Full putBottle OR Not same color on top
                else if(putbottle.isFull() || !putbottle.getTopColor().equals(picColor)){
                    System.out.println("->not same color or not full");
                    continue;
                }
                //Same color on top
                else{
                    System.out.println("else");
                    potentialActions.add(new Action(i, j));
                }
            }
        }
        return potentialActions;
    }

    public Optional<State> applyAction(Action action) {
        State newState = new State(this);

        String pickedColor = newState.getBottle(action.getPickBottle()).popTopColor();
        newState.getBottle(action.getPutBottle()).pushTopColor(pickedColor);

        return Optional.of(newState);
    }

    public void printState() {
        System.out.println("\n=====================\nState: ");
        bottleList.forEach(bottle -> bottle.printBottle());
    }
}
