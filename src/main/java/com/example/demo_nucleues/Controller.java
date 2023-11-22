package com.example.demo_nucleues;

import com.example.demo_nucleues.model.ReloadBIWBQModel;
import com.example.demo_nucleues.service.Action;
import com.example.demo_nucleues.model.DeploymentModel;
import com.example.demo_nucleues.service.DataflowService;
import com.example.demo_nucleues.service.DeploymentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Director", description = "Cool Interface", version = "v1"))
public class Controller {
    private final DeploymentService deploymentService;
    private final DataflowService dataflowService;

    @PostMapping("/action/kubernetes")
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name = "Kubernetes", description = "Deploys a service to Kubernetes")
    public void deployKubernetes(@Valid @ParameterObject DeploymentModel model){
        deploymentService.deploy(model);

    }

    @DeleteMapping("/action/dataflow/{ruleName}")
    @Tag(name = "Dataflow", description = "Deletes a dataflow job")
    public void deleteDataflowJob(@Valid @PathVariable String ruleName){
        dataflowService.delete(ruleName);

    }

    @PostMapping ("/action/reloadBiw/{ruleName}")
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name="Reload from BigQuery", description = "Reload Data")
    public void  reloadBiw(@PathVariable String ruleName, @ParameterObject ReloadBIWBQModel model){
        System.out.printf("Rule %s has been reloaded from %s", ruleName, model.loadFrom());
    }

    @GetMapping("/actions")
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name = "All Actions")
    public void all(@RequestParam List<Action> actions){
        actions.forEach(System.out::println);
    }
}
