package com.bdv.demo.springdemo.controller;

import com.bdv.demo.springdemo.dto.ModelDTO;
import com.bdv.demo.springdemo.model.ModelEntity;
import com.bdv.demo.springdemo.repository.ModelRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @Autowired
    private ModelRepository modelRepository;

    @PostMapping("/model")
    public void saveModel(@RequestBody ModelDTO modelDTO) {
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setValue(modelDTO.getValue());
        modelRepository.save(modelEntity);
    }

    @GetMapping("/model/{id}")
    public ModelDTO getModelById(@PathVariable Long id) {
        Optional<ModelEntity> modelEntity = modelRepository.findById(id);
        ModelDTO modelDTO = new ModelDTO();
        if (modelEntity.isPresent()) {
            modelDTO.setId(modelEntity.get().getId());
            modelDTO.setValue(modelEntity.get().getValue());
        }
        return modelDTO;
    }

    @GetMapping("/model")
    public List<ModelDTO> getAllModels() {
        return Lists.newArrayList(modelRepository.findAll()).stream().map(en -> {
            ModelDTO modelDTO = new ModelDTO();
            modelDTO.setValue(en.getValue());
            modelDTO.setId(en.getId());
            return modelDTO;
        }).collect(Collectors.toList());
    }
}
