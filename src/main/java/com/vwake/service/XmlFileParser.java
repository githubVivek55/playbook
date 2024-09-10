package com.vwake.service;

import com.vwake.type.FileType;
import org.springframework.stereotype.Service;

@Service(FileType.XML)
public class XmlFileParser implements FileParser{
    @Override
    public String parse() {
        return "Reading xml file";
    }
}
