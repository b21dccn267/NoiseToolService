package com.ltnhung.noiseapp.controller;

import com.ltnhung.noiseapp.config.FirebaseConfig;
import com.ltnhung.noiseapp.entity.NoiseData;
import com.ltnhung.noiseapp.service.FirebaseService;
import com.ltnhung.noiseapp.service.NoiseDataService;
import com.ltnhung.noiseapp.service.TimeDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noise")
@AllArgsConstructor
public class NoiseController {
    private final FirebaseService firebaseService;

    private final NoiseDataService noiseDataService;

    private final TimeDataService timeDataService;

    @GetMapping("/data")
    public List<NoiseData> getNoiseData() throws InterruptedException {
        return firebaseService.getNoiseData();
    }

    @PostMapping("/add")
    public NoiseData saveNoiseData(@RequestBody NoiseData noiseData) {
//        return noiseDataService.saveNoiseData(noiseData);
        return timeDataService.saveNoiseDataTime(noiseData);
    }

    @GetMapping("/list")
    public List<NoiseData> getAllNoiseData() {
        return noiseDataService.getAllNoiseData();
    }

    @GetMapping("/{id}")
    public NoiseData getNoiseDataById(@PathVariable Long id) {
        return noiseDataService.getNoiseDataById(id);
    }
}
