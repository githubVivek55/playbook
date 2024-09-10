package com.vwake.service;

import com.vwake.type.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FileParserFactory {
    private final Map<String, FileParser> fileParser;

    public FileParser getFileParser(String type){
        FileParser parser = fileParser.get(type);
        if(Objects.isNull(parser)){
            throw new IllegalArgumentException("Invalid file type");
        }
        return parser;
    }

}
