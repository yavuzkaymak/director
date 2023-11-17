package com.example.demo_nucleues.service;

import com.example.demo_nucleues.model.DeploymentModel;
import org.springframework.stereotype.Service;

@Service
public class DeploymentService {
    public void deploy(DeploymentModel model){
        System.out.printf("Deployment service has %s with %d replicas deployed%n", model.name(), model.replica());
    }
}
