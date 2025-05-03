package com.ltnhung.noiseapp.service.impl;

import com.ltnhung.noiseapp.entity.NoiseData;
import com.ltnhung.noiseapp.repository.NoiseDataRepository;
import com.ltnhung.noiseapp.service.NoiseDataService;
import com.ltnhung.noiseapp.service.TimeDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class TimeDataServiceImpl implements TimeDataService {
    private final NoiseDataRepository noiseDataRepository;

    @Override
    public NoiseData saveNoiseDataTime(NoiseData noiseData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentTime = LocalDateTime.now().format(formatter);

        noiseData.setTimestamp(currentTime);

        return noiseDataRepository.save(noiseData);
    }
}
