package com.plane.service;

import com.plane.pojo.plane.Navy;
import com.plane.pojo.plane.Worker;

import java.util.List;

public interface NavyService {
    public void saveNavy(Navy plane, Worker worker);
    public Navy getNavy(Integer id);
    public List<Navy> getPlanesOfWorker(Worker worker);
    public void updateNavy(Navy plane);
    public void deleteNavy(Navy plane);
}
