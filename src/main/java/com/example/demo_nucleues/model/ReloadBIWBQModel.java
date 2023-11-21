package com.example.demo_nucleues.model;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema
public record ReloadBIWBQModel(
        @Parameter(required = true, example = "2022-01-01 00:00:00") String loadFrom,
        @Parameter(required = true, example = "2022-01-01 00:00:00") String loadTo,
        @Parameter(required = true , in = ParameterIn.QUERY, array = @ArraySchema)List<String> targetObject,
        @Parameter(required = true) String deltaLoadRefObject) {
}
