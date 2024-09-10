package com.vwake.service;

import com.vwake.type.FileType;
import org.springframework.stereotype.Service;

@Service(FileType.JSON)
public class JsonFileParser implements FileParser{

    @Override
    public String parse() {
        return "Read JSON file";
    }
}
