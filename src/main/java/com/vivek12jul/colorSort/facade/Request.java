package com.vivek12jul.colorSort.facade;

import com.vivek12jul.colorSort.service.state.Bottle;
import com.vivek12jul.colorSort.service.state.State;

import java.util.ArrayList;

public class Request {

    private int bottleCount;
    private int bottleCapacity;
    private ArrayList<ArrayList<String>> matrix;

    public Request(int bottleCount, int bottleCapacity, ArrayList<ArrayList<String>> matrix) {
        this.setBottleCount(bottleCount);
        this.setBottleCapacity(bottleCapacity);
        this.setMatrix(matrix);
    }

    public int getBottleCount() {
        return bottleCount;
    }

    public void setBottleCount(int bottleCount) {
        State.setBottleCount(bottleCount);
        this.bottleCount = bottleCount;
    }

    public int getBottleCapacity() {
        return bottleCapacity;
    }

    public void setBottleCapacity(int bottleCapacity) {
        State.setBottleCapacity(bottleCapacity);
        this.bottleCapacity = bottleCapacity;
    }

    public ArrayList<ArrayList<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<String>> matrix) {
        this.matrix = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> innerList : matrix) {
            this.matrix.add(new ArrayList<String>(innerList));
        }
    }

    public State toState(){

        ArrayList<Bottle> bottleList = new ArrayList<>();

        for(ArrayList<String> innerList : matrix) {
            Bottle bottle = new Bottle(innerList);
            bottleList.add(bottle);
        }
        State state = new State(bottleList);
        System.out.println("\n\n**********************************************");
        for(int i=0;i<bottleCount;i++) {
            Bottle bottle = state.getBottle(i);
            System.out.println(bottle.getColors().size());
            bottle.printBottle();
        }

        return state;
    }
}
