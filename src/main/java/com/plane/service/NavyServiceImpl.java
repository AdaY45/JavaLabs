package com.plane.service;

import com.plane.pojo.plane.Navy;
import com.plane.pojo.people.Worker;
import com.plane.repository.NavyRepository;
import com.plane.repository.WorkerRepository;

import java.util.Collections;
import java.util.List;

public class NavyServiceImpl implements NavyService{
    private NavyRepository navyRepository;
    private WorkerRepository workerRepository;

    @Override
    public void saveNavy(Navy plane, Worker worker) {
        workerRepository.updateWorker(worker).addPlane(plane);
        navyRepository.createPlane(plane);
    }

    @Override
    public Navy getNavy(Integer id) {
        return navyRepository.findPlaneById(id);
    }

    @Override
    public List<Navy> getPlanesOfWorker(Worker worker) {
        return Collections.emptyList();
    }

    @Override
    public void updateNavy(Navy plane) {
        navyRepository.updatePlane(plane);
    }

    @Override
    public void deleteNavy(Navy plane) {
        navyRepository.deletePlane(plane);
    }
}
