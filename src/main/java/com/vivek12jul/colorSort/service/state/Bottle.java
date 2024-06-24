package com.vivek12jul.colorSort.service.state;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Objects;

public class Bottle {

    private static Integer BOTTLE_CAPACITY;
    private ArrayList<String> colors;

    public Bottle(ArrayList<String> colors) {
        this.setColors(colors);
    }
    public Bottle(Bottle bottle){
        this.setColors(bottle.getColors());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottle bottle = (Bottle) o;
        return Objects.equals(colors, bottle.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colors);
    }

    public static void setBottleCapacity(Integer bottleCapacity) {
        Bottle.BOTTLE_CAPACITY = bottleCapacity;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = new ArrayList<>(colors);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return colors.isEmpty();
    }
    @JsonIgnore
    public boolean isFull() {
        return colors.size() == BOTTLE_CAPACITY;
    }

    @JsonIgnore
    public boolean isSameColor() {
        return colors.stream()
                .allMatch(color -> color.equals(colors.get(0)));
    }

    @JsonIgnore
    public String getTopColor() {
        if(this.isEmpty()){
            throw new RuntimeException("Bottle is empty. cant access top color");
        }
        return colors.get(colors.size()-1);
    }

    public String popTopColor() {
        if(this.isEmpty()){
            throw new RuntimeException("Bottle is empty. cant pop top color");
        }
        return colors.remove(colors.size()-1);
    }

    public void pushTopColor(String pickedColor) {
        if(this.isFull()){
            System.out.println(this.getColors().size() + " " +BOTTLE_CAPACITY);
            throw new RuntimeException("Bottle is full. cant push color");
        }
        colors.add(pickedColor);
    }

    public void printBottle() {
        colors.forEach(color -> System.out.println(color+ ", "));
        System.out.println("\n-------");
    }
}
