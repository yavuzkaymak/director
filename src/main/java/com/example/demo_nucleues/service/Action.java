package com.example.demo_nucleues.service;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum Action {
    DATAFLOW,
    KUBERNETES,


}
