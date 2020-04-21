package com.adl.stock.Entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Repository
public class test {
    @GetMapping(path = "/Test")
    public String getString() {
        return "jesuis la ";
    }
}
