package com.chamil.qualitycoder.csvimport.v0.service;

import com.chamil.qualitycoder.csvimport.v0.repository.User;
import com.chamil.qualitycoder.csvimport.v0.repository.UserRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserServiceImpl implements UserService {

    public static final int EXPECTED_CSV_RECORD_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MIN_AGE = 18;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void importUsers(MultipartFile file) {
        Map<Integer, List<String>> errors = new ConcurrentHashMap<>();

        try {
            CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
            int lineNo = 0;
            for (String[] line : reader) {
                List<String> lineErrors = validate(line);
                errors.put(lineNo++, lineErrors);

                if (lineErrors.isEmpty()) {
                    User user = new User(line[0], line[1], Integer.parseInt(line[2]));
                    userRepository.save(user);
                }
            }

        } catch (IOException e) {
            throw new DataImportException("Reading CSV file [" + file.getOriginalFilename() + "]  failed.", e);
        }
    }

    private List<String> validate(String[] values) {

        List<String> list = new ArrayList<>();

        if (values.length != EXPECTED_CSV_RECORD_LENGTH) {
            list.add("The expected length is '" + EXPECTED_CSV_RECORD_LENGTH + "'. found " + values.length);
        } else if (values[0].length() > MAX_NAME_LENGTH || values[0].length() == 0) {
            list.add("Invalid name length " + values[0].length() + ". Should not exceed " + MAX_NAME_LENGTH +".");
        }

        int age;

        try {
            age = Integer.parseInt(values[2]);
            if (age < MIN_AGE) {
                list.add("Age must be 18 or more. Minimum expected age is " + MIN_AGE);
            }
        } catch (NumberFormatException e) {
            list.add("Age must be a numeric value.");
        }


        return list;
    }
}