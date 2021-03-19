package com.plane.pojo.plane;

import com.plane.pojo.people.Worker;

public class Reparation {
    private Detail detailReplacement;
    private String partReparation;
    private String status;


    public Reparation(Detail detailReplacement, String partReparation) {
        this.detailReplacement = detailReplacement;
        this.partReparation = partReparation;
    }

    public void saveDetail(Worker workerResponsible) {
    }

    public void saveDetail(Navy planeToRepair) {
    }

    public void setReparationStatus(String status) {
        this.status = status;
    }

    public void savePart(Navy plane) {
    }

    public void saveWorker(Worker workerToBeSet, PlanePart planePart) {
    }
}
