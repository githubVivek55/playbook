package com.vwake.controller;

import com.vwake.service.FileParser;
import com.vwake.service.FileParserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StrategyController {

    private final FileParserFactory fileParserFactory;

    @GetMapping(path = "/strategy/{type}")
    public String testStrategy(@PathVariable String type){
        FileParser fileParser = fileParserFactory.getFileParser(type);
        return fileParser.parse();
    }
}
