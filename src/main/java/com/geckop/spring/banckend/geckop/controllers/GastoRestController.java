package com.geckop.spring.banckend.geckop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
@RestController
@RequestMapping("/api")
public class GastoRestController {

}
