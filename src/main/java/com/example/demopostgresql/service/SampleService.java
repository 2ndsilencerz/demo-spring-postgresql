package com.example.demopostgresql.service;

import com.example.demopostgresql.entity.SampleEntity;
import com.example.demopostgresql.model.SampleModel;
import com.example.demopostgresql.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class SampleService {

    final SampleRepository repository;

    Logger logger = LoggerFactory.getLogger(getClass());

    public SampleService(SampleRepository repository) {
        this.repository = repository;
    }

    public SampleModel testInput(SampleModel model) {
        Random rng = new Random();
        if (model == null) {
            model = new SampleModel();
            model.setMessage("");
        }

        Long rngResult = rng.nextLong();
        model.setId(rngResult);
        model.setMessage(model.getMessage().concat(String.valueOf(rngResult)));
        SampleEntity entity = new SampleEntity();
        BeanUtils.copyProperties(model, entity);
        logger.info("saving {}", entity);
        entity = repository.save(entity);
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public SampleModel testGet(Long id) {
        SampleModel model = new SampleModel();
        Optional<SampleEntity> result = repository.findById(id);
        if (result.isPresent()) {
            logger.info("found {}", result.get());
            BeanUtils.copyProperties(result.get(), model);
        }
        return model;
    }
}
