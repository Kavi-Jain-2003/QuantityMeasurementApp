package com.app.quantitymeasurement.history.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.quantitymeasurement.history.entity.UserHistory;
import com.app.quantitymeasurement.history.repository.UserHistoryRepository;

@Service
public class UserHistoryService {

    private final UserHistoryRepository repository;

    public UserHistoryService(UserHistoryRepository repository) {
        this.repository = repository;
    }

    public void saveHistory(String type, String input, String output, String status, String username) {

        System.out.println("Saving History...");
        System.out.println("TYPE: " + type);
        System.out.println("INPUT: " + input);
        System.out.println("OUTPUT: " + output);
        System.out.println("USER: " + username);

        UserHistory history = new UserHistory();
        history.setOperationType(type);
        history.setInputData(input);
        history.setOutputData(output);
        history.setStatus(status);
        history.setTimestamp(LocalDateTime.now());
        history.setUsername(username);   

        repository.save(history);
    }


}
