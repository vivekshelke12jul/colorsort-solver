package com.vivek12jul.colorSort.service.state;

public class Action {
    private Integer pickBottle;
    private Integer putBottle;

    public Action(Integer pickBottle, Integer putBottle) {
        this.setPickBottle(pickBottle);
        this.setPutBottle(putBottle);
    }

    public Action(Action action) {
        this.setPickBottle(action.getPickBottle());
        this.setPutBottle(action.getPutBottle());
    }

    public Integer getPickBottle() {
        return pickBottle;
    }

    public void setPickBottle(Integer pickBottle) {
        this.pickBottle = pickBottle;
    }

    public Integer getPutBottle() {
        return putBottle;
    }

    public void setPutBottle(Integer putBottle) {
        this.putBottle = putBottle;
    }
}
