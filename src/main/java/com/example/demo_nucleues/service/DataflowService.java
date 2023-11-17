package com.example.demo_nucleues.service;

import org.springframework.stereotype.Service;

@Service
public class DataflowService {
    public void delete(String ruleName){
        System.out.printf("Deleted the dataflow job %s", ruleName);
    }
}
