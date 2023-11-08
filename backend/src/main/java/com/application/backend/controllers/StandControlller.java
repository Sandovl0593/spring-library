package com.application.backend.controllers;

import com.application.backend.services.source.BookServiceSrc;
import com.application.backend.services.source.StandServiceSrc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stand")
public class StandControlller {
    @Autowired
    StandServiceSrc standService;
    @Autowired
    BookServiceSrc bookService;

    
}
