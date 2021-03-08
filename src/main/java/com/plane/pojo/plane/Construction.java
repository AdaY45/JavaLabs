package com.plane.pojo.plane;

public class Construction {
    private String name;
    Worker worker;

    public Construction(String name, Worker worker) {
        this.name = name;
        this.worker = worker;
    }

    public String getName() {
        return name;
    }

    public Worker getWorker() {
        return worker;
    }
}
