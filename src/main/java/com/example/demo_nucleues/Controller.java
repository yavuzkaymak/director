package com.example.demo_nucleues;

import com.example.demo_nucleues.model.DeploymentModel;
import com.example.demo_nucleues.service.DataflowService;
import com.example.demo_nucleues.service.DeploymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final DeploymentService deploymentService;
    private final DataflowService dataflowService;

    @GetMapping("/action/kubernetes")
    @Tag(name = "Kubernetes", description = "Deploys a service to Kubernetes")
    public void deployKubernetes(@Valid @ParameterObject DeploymentModel model){
        deploymentService.deploy(model);

    }

    @DeleteMapping("/action/dataflow/{ruleName}")
    @Tag(name = "Dataflow", description = "Deletes a dataflow job")
    public void deleteDataflowJob(@PathVariable String ruleName){
        dataflowService.delete(ruleName);

    }

}
