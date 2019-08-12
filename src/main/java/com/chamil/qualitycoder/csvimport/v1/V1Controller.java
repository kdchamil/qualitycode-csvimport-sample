package com.chamil.qualitycoder.csvimport.v1;

import com.chamil.qualitycoder.csvimport.v0.repository.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class V1Controller {

    private final Validator validator;
    private final Mapper<User> mapper;
    private final Store<User> store;

    public V1Controller(Validator validator, Mapper<User> mapper, Store<User> store) {

        this.validator = validator;
        this.mapper = mapper;
        this.store = store;
    }

    @PostMapping("/users")
    public void handleFile(@RequestParam MultipartFile file) throws IOException {

        if (!StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), "csv")) {
            throw new IllegalArgumentException("Only CSV allowed.");
        }

        DataSource dataSource = new CSVDataSource(file.getInputStream());

        Command<User> importCommand = new ImportCommand<>(
                validator, store, dataSource, mapper);

        importCommand.execute();

    }
}
