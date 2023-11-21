package com.example.demo_nucleues.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record DeploymentModel(String name, Integer replica) {
}
