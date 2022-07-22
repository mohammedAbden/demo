package com.example.demo.service;

import com.example.demo.entity.Random;
import com.example.demo.repository.RandomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RandomUUIDServiceImpl implements RandomUUIDService {

    private final RandomRepository randomRepository;

    @Override
    public Random generateNewUUID() {
        Random random = Random.builder()
                .uuid(UUID.randomUUID().toString())
                .build();

        return randomRepository.save(random);
    }
}
